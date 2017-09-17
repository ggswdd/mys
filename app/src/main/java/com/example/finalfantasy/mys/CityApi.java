package com.example.finalfantasy.mys;


import com.example.finalfantasy.mys.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CityApi {
    @GET("forecast")
    Call<Example> getData(@Query("appid") String resourceName, @Query("q") String name);
}
