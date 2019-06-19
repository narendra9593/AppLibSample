package com.volansys.network.retrofit;

import com.google.gson.JsonObject;
import com.volansys.network.interfaces.NetworkResponseListener;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitApiLogic {

    /**
     * calling POST api with request parameter and return response using NetworkResponseListener
     *
     * @param url                      is api end point
     * @param jsonObject               for request parameter
     * @param token                    is use for user authentication
     * @param mNetworkResponseListener return response
     */
    public static void callingPostApi(String url, JsonObject jsonObject, String token,
                                      final NetworkResponseListener mNetworkResponseListener) {
        Call<JsonObject> call = ApiClient.getClient().callingPostRequest(
                url, getCustomHeader(token), jsonObject);

        //noinspection NullableProblems
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                mNetworkResponseListener.onSuccessResponse(String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mNetworkResponseListener.onFailureResponse(t.getMessage());
            }
        });
    }

    /**
     * calling PUT api with request parameter and return response using NetworkResponseListener
     *
     * @param url                      is api end point
     * @param jsonObject               for request parameter
     * @param token                    is use for user authentication
     * @param mNetworkResponseListener return response
     */
    public static void callingPutApi(String url, JsonObject jsonObject, String token,
                                     final NetworkResponseListener mNetworkResponseListener) {
        Call<JsonObject> call = ApiClient.getClient().callingPutRequest(url,
                getCustomHeader(token), jsonObject);
        //noinspection NullableProblems
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                mNetworkResponseListener.onSuccessResponse(String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mNetworkResponseListener.onFailureResponse(t.getMessage());
            }
        });
    }

    /**
     * calling GET api with request parameter and return response using NetworkResponseListener
     *
     * @param url                      is api end point
     * @param token                    is use for user authentication
     * @param mNetworkResponseListener return response
     */
    public static void callingGetApi(String url, String token,
                                     final NetworkResponseListener mNetworkResponseListener) {


        Call<JsonObject> call = ApiClient.getClient().callingGetRequest(url, getCustomHeader(token));
        //noinspection NullableProblems
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                mNetworkResponseListener.onSuccessResponse(String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mNetworkResponseListener.onFailureResponse(t.getMessage());
            }
        });
    }

    /**
     * @param token access token for security
     * @return
     */
    @SuppressWarnings("JavaDoc")
    private static Map<String, String> getCustomHeader(String token) {
        Map<String, String> map = new HashMap<>();

        map.put("Accept", "application/json");
        map.put("Content-Type", "application/json");
        if (!token.isEmpty()) {
            map.put("authToken", token);
        }

        return map;
    }
}
