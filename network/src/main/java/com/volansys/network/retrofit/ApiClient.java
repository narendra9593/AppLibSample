package com.volansys.network.retrofit;


import com.volansys.network.BuildConfig;
import com.volansys.network.interfaces.IRequestInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

 class ApiClient {


    private static IRequestInterface requestInterface = null;

    /**
     * Create retrofit instance
     * retrofit instance bind to IRequestInterface
     * IRequestInterface is used for calling post and get api
     * HttpLoggingInterceptor is used for api log
     * @return IRequestInterface
     */
    static IRequestInterface getClient() {
        if (requestInterface == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//            httpClient.interceptors().add(new LogJsonInterceptor());
            if (BuildConfig.DEBUG) {
                httpClient.addInterceptor(logging);
            }
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            /* creating object of interface and getting response from api */
            requestInterface = retrofit.create(IRequestInterface.class);
        }
        return requestInterface;
    }
}
