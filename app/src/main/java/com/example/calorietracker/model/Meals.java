package com.example.calorietracker.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity
public class Meals {

    public String food_name;

    public double serving_weight_grams;

    public double nf_calories;

    public double nf_total_fat;

    public double nf_total_carbohydrate;

    public double nf_protein;

    public String date;

    public Meals(String food_name, double serving_weight_grams, double nf_calories, double nf_total_fat, double nf_total_carbohydrate, double nf_protein, String date) {
        this.food_name = food_name;
        this.serving_weight_grams = serving_weight_grams;
        this.nf_calories = nf_calories;
        this.nf_total_fat = nf_total_fat;
        this.nf_total_carbohydrate = nf_total_carbohydrate;
        this.nf_protein = nf_protein;
        this.date = date;
    }

    public Meals(String food_name, double serving_weight_grams, double nf_calories, double nf_total_fat, double nf_total_carbohydrate, double nf_protein) {
        this.food_name = food_name;
        this.serving_weight_grams = serving_weight_grams;
        this.nf_calories = nf_calories;
        this.nf_total_fat = nf_total_fat;
        this.nf_total_carbohydrate = nf_total_carbohydrate;
        this.nf_protein = nf_protein;
    }

    public String getFood_name() {
        return food_name;
    }

    public double getServing_weight_grams() {
        return serving_weight_grams;

    }

    public double getNf_calories() {
        return nf_calories;
    }

    public double getNf_total_fat() {
        return nf_total_fat;
    }

    public double getNf_total_carbohydrate() {
        return nf_total_carbohydrate;
    }

    public double getNf_protein() {
        return nf_protein;
    }

    public String getDate() {
        return date;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setServing_weight_grams(double serving_weight_grams) {
        this.serving_weight_grams = serving_weight_grams;
    }

    public void setNf_calories(double nf_calories) {
        this.nf_calories = nf_calories;
    }

    public void setNf_total_fat(double nf_total_fat) {
        this.nf_total_fat = nf_total_fat;
    }

    public void setNf_total_carbohydrate(double nf_total_carbohydrate) {
        this.nf_total_carbohydrate = nf_total_carbohydrate;
    }

    public void setNf_protein(double nf_protein) {
        this.nf_protein = nf_protein;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
