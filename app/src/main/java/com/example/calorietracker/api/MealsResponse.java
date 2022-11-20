package com.example.calorietracker.api;

import com.example.calorietracker.model.Meals;

public class MealsResponse {
    public String food_name;

    public double serving_weight_grams;

    public double nf_calories;

    public double nf_total_fat;

    public double nf_total_carbohydrate;

    public double nf_protein;

    public Meals getMeals(){
        return new Meals(food_name,serving_weight_grams,nf_calories,nf_total_fat,nf_total_carbohydrate,nf_protein);
    }
}
