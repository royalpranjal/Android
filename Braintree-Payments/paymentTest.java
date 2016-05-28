package com.pranjal;

import android.app.Activity;
import android.content.Intent;

import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.Card;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.api.models.PaymentMethodNonce;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class paymentTest extends Activity implements PaymentMethodNonceCreatedListener {

    private static final String BASE_URL = "your_Server_base_url/host url....Eg. google.com";
    private String token;
    private String nonce;
    private BraintreeFragment mBrainTreeFragment;

    public void getToken() {
        RestAdapter adapter = new RestAdapter
                .Builder()
                .setEndpoint(BASE_URL)
                .build();

        ClientTK Capi = adapter.create(ClientTK.class);

        Capi.getToken(new Callback<ClientToken>(){

            @Override
            public void success(ClientToken clientToken, Response response) {
                if(clientToken.getStatus().equalsIgnoreCase("success")){
                    token = clientToken.getData().getClientToken();
                    tokenizeCard();
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void tokenizeCard(){
        try{
            // take card details & use them to tokenize the card
            mBrainTreeFragment = BraintreeFragment.newInstance(RegisterPaymentActivity.this, token);
            CardBuilder cardBuilder = new CardBuilder()
                    .cardNumber(inputCardNumber.getText().toString())
                    .expirationDate(inputCardMonth.getText().toString() + "/" + inputCardYear.getText().toString());
            Card.tokenize(mBrainTreeFragment, cardBuilder);
        }catch(InvalidArgumentException e){

        }
    }

    // this method is implemented just after the card is tokenized
    @Override
    public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
        // getting nonce from braintree server
        nonce = paymentMethodNonce.getNonce();
        final String email = getIntent().getExtras().getString(TecxiConstants.EMAIL);

        // sending the nonce to our server
        makeAPIcall(nonce, email);
    }

    private void makeAPIcall(String nonce, final String email){
        RestAdapter adapter = new RestAdapter
                .Builder()
                .setEndpoint(BASE_URL)
                .build();

        SendNonceToServer Sapi = adapter.create(SendNonceToServer.class);

        // sending nonce to server
        AuthTokenRequest request = new AuthTokenRequest();
        request.setEmail(email);
        request.setPayment_method_nonce(nonce);

        Sapi.sendNonce(request, new Callback<ClientTokenFromNonce>() {
            @Override
            public void success(ClientTokenFromNonce clientTokenFromNonce, Response response) {
                // getting the auth Token from server
                String auth_token = clientTokenFromNonce.getData().getClientToken();

                // searching the driver by email...email is the primary key
                Realm realm = Realm.getInstance(RegisterPaymentActivity.this);
                RealmResults<DriverUserDetails> results = realm
                        .where(DriverUserDetails.class)
                        .equalTo("driverEmail", email)
                        .findAll();

                // storing the auth token in the database so that we know that card is tokenized
                // & payments can be directly made
                realm.beginTransaction();
                DriverUserDetails u = results.get(0);
                u.setDriverAuthToken(auth_token);
                realm.commitTransaction();

                Intent verificationIntent = new Intent(RegisterPaymentActivity.this, TextDocumentActivity.class);
                startActivity(verificationIntent);
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }
}
