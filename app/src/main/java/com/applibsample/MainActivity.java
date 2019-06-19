package com.applibsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.volansys.network.interfaces.NetworkResponseListener;

import static com.volansys.network.retrofit.RetrofitApiLogic.callingGetApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callingGetApi("contacts/", "", new NetworkResponseListener() {
            @Override
            public void onSuccessResponse(String response) {

            }

            @Override
            public void onFailureResponse(String message) {

            }
        });
    }

    private void callAPI() {

       /* JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", "sanjay.hirani");
        jsonObject.addProperty("password", "Sanjay@123");
        callingPostApi("user/login", jsonObject, "", new NetworkResponseListener() {
            @Override
            public void onSuccessResponse(String response) {
//                        Log.d("onSuccess", "=======>>>> " + response);
            }

            @Override
            public void onFailureResponse(String response) {
                Log.d("onSuccess", "=======>>>> " + response);
            }
        });*/
    }
}
