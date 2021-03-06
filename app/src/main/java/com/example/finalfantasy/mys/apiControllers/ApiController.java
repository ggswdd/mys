package com.example.finalfantasy.mys.apiControllers;


import com.example.finalfantasy.mys.interfaces.CityApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    public static CityApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CityApi mCityApi = retrofit.create(CityApi.class);
        return mCityApi;
    }
}
