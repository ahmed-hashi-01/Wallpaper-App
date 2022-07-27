package com.example.wallpaperapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static  Retrofit retrofit = null;
    public static final String API = "563492ad6f91700001000001f63f8a2872a04ab1a6529fe8611b589f";

    public static APIinterface getApiInterface (){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(APIinterface.BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APIinterface.class);
    }

}
