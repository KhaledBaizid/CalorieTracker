package com.example.calorietracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.repository.MealsRepository;

public class MealViewModel extends AndroidViewModel {
    private MealsRepository mealsRepository;
    public MealViewModel(@NonNull Application application) {
        super(application);
        mealsRepository=MealsRepository.getInstance(getApplication());
    }

    public MealsList getMealList(String food){
        return mealsRepository.getInformationFromAPI(food);
    }
}
