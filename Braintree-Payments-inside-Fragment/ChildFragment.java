public class ChildFragment extends Fragment implements PaymentMethodNonceCreatedListener{
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_child, container, false);
        return rootView;
    }

    private void tokenizeCard() {
        try {
            BraintreeFragment mBraintreeFragment = BraintreeFragment.newInstance(getActivity(), clientToken);
            CardBuilder cardBuilder = new CardBuilder()
                    .cardNumber(inputCardNumber.getText().toString())
                    .expirationMonth(inputCardMonth.getText().toString())
                    .expirationYear(inputCardYear.getText().toString())
                    .cvv(inputCardCVV.getText().toString());
            Card.tokenize(mBraintreeFragment, cardBuilder);
        } catch (Exception e) {
            Snackbar.make(getView(), "Something went wrong! Please try again" +e.getCause(), Snackbar.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
        String nonce = paymentMethodNonce.getNonce();
    }
}
