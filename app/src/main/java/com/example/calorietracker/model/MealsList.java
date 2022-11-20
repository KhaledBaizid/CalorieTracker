package com.example.calorietracker.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MealsList {

    @SerializedName("foods")
    public List<Meals> mealsList;

    public MealsList()
    {
        mealsList = new ArrayList<>();
    }

    public Meals getMeal(int index)
    {
        return mealsList.get(index);
    }

    @Override
    public String toString() {
        return "MealsList{" +
                "mealsList=" + mealsList +
                '}';
    }
}
