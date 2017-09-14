package com.example.finalfantasy.mys;

/**
 * Created by FinalFantasy on 14.09.2017.
 */
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CityApi {
    @GET("forecast")
    Call<List<City>> getData(@Query("appid") String resourceName, @Query("q") String name);
}
