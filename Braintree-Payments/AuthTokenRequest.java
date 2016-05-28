package com.pranjal;

public class AuthTokenRequest {

    private String payment_method_nonce;
    private String email;

    public String getEmail() {
        return email;
    }

    public String getPayment_method_nonce() {
        return payment_method_nonce;
    }

    public void setPayment_method_nonce(String payment_method_nonce) {
        this.payment_method_nonce = payment_method_nonce;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
