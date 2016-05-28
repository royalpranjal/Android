package com.pranjal;

public interface ClientTK {
       @GET("your_server_address")
       void getToken(Callback<ClientToken> callback);
}
