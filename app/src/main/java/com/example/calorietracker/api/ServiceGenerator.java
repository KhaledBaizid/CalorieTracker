package com.example.calorietracker.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static final String BASE_URL = "https://trackapi.nutritionix.com/";
    //private static final String BASE_URL = "https://trackapi.nutritionix.com/v2/natural/nutrients/";

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MealsApi mealsAPI = retrofit.create(MealsApi.class);

    public static MealsApi getApiEndpoint()
    {
        return mealsAPI;
    }
}
