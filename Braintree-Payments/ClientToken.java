package com.pranjal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientToken {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private ClientTokenData data;

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public ClientToken withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     *
     * @return
     * The data
     */
    public ClientTokenData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(ClientTokenData data) {
        this.data = data;
    }

    public ClientToken withData(ClientTokenData data) {
        this.data = data;
        return this;
    }

}