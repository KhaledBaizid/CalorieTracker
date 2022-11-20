package com.example.calorietracker.api;

import com.example.calorietracker.model.ApiQuery;
import com.example.calorietracker.model.MealsList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MealsApi {

    //This is the type of the content being sent and received
    String CONTENT_TYPE = "Content-Type:application/json";

    String APPLICATION_ID = "x-app-id:baf7d07c";

    String APPLICATION_KEY = "x-app-key:566e5eaba100b90b384098704c93cf94";

    @POST("v2/natural/nutrients")
    @Headers({CONTENT_TYPE, APPLICATION_ID, APPLICATION_KEY})
    Call<MealsList> getFoodInformation(@Body ApiQuery query );
}
