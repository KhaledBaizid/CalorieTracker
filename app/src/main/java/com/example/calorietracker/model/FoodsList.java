package com.example.calorietracker.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FoodsList {

    @SerializedName("foods")
    public List<Foods> foodsList;

    public FoodsList()
    {
        foodsList = new ArrayList<>();
    }
    public Foods getFood(int index)
    {
        return foodsList.get(index);
    }

    @Override
    public String toString() {
        return "FoodsList{" +
                "foodsList=" + foodsList +
                '}';
    }
}
