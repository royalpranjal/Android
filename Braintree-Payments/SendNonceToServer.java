package com.pranjal;

public interface SendNonceToServer {
    @POST("your_server_address")
    void sendNonce(@Body AuthTokenRequest request,Callback<ClientTokenFromNonce> callback);
}
