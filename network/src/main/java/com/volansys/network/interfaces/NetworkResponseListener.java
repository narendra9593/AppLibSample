package com.volansys.network.interfaces;

public interface NetworkResponseListener {
    void onSuccessResponse( String response);

    void onFailureResponse(String message);
}
