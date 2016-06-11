public class PaymentActivity extends AppCompatActivity implements PaymentMethodNonceCreatedListener {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

    @Override
    public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
        try{
            if (fragment instanceof PaymentFragment) {
                ((PaymentFragment) fragment).onPaymentMethodNonceCreated(paymentMethodNonce);
            }
        }catch (Exception e){
            Toast.makeText(ParentActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
