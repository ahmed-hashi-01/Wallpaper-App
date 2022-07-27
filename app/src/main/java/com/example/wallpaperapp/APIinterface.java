package com.example.wallpaperapp;

import static com.example.wallpaperapp.ApiUtilities.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIinterface {
    String BaseUrl = "https://api.pexels.com/v1/";

    @Headers("Authorization: "+ API)
    @GET("currated")
    Call<SearchModel> getImage(
            @Query("page") int page ,
            @Query("per_page") int per_page
    );

    @Headers("Authorization: "+ API)
    @GET("search")
    Call<SearchModel> getImage(
            @Query("query") String query ,
            @Query("page") int page ,
            @Query("per_page") int per_page
    );
}