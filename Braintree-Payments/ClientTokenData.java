package com.pranjal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientTokenData {

    @SerializedName("client_token")
    @Expose
    private String clientToken;

    /**
     *
     * @return
     * The clientToken
     */
    public String getClientToken() {
        return clientToken;
    }

    /**
     *
     * @param clientToken
     * The client_token
     */
    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public ClientTokenData withClientToken(String clientToken) {
        this.clientToken = clientToken;
        return this;
    }

}