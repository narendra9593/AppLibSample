package com.volansys.network.interfaces;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface IRequestInterface {

    @POST
    Call<JsonObject> callingPostRequest(@Url String url, @HeaderMap Map<String, String> headers,
                                        @Body JsonObject request);
    @GET
    Call<JsonObject> callingGetRequest(@Url String url, @HeaderMap Map<String, String> headers);

    @PUT
    Call<JsonObject> callingPutRequest(@Url String url, @HeaderMap Map<String, String> headers,
                                        @Body JsonObject request);
}
