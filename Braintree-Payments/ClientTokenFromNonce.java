package com.pranjal;

public class ClientTokenFromNonce {

    private String status;
    private ClientTokenFromNonceData data;


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

    /**
     *
     * @return
     * The data
     */
    public ClientTokenFromNonceData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(ClientTokenFromNonceData data) {
        this.data = data;
    }


}
