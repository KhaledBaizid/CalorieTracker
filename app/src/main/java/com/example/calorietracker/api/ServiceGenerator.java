package com.example.calorietracker.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static final String BASE_URL = "https://trackapi.nutritionix.com/";


    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static FoodsApi foodsAPI = retrofit.create(FoodsApi.class);

    public static FoodsApi getApiEndpoint()
    {
        return foodsAPI;
    }
}
