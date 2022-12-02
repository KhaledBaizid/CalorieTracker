package com.example.calorietracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.repository.MealsRepository;

import java.util.List;

public class MealViewModel extends AndroidViewModel {
    private MealsRepository mealsRepository;
    private MutableLiveData<MealsList> meals;
    private MutableLiveData <List<Meals>> listMutableLiveData;

    public MealViewModel(@NonNull Application application) {
        super(application);
        mealsRepository=MealsRepository.getInstance(getApplication());
        meals = new MutableLiveData<>();
        listMutableLiveData=new MutableLiveData<>();
        MealsList newList = new MealsList();
    }
    public LiveData<List<Meals>> getListOfMealsPerDate(){

        return listMutableLiveData;
    }

    public LiveData<MealsList> getAllMeals(){
        return meals;
    }
    public  void getMealList(String food){
        meals.setValue(mealsRepository.getInformationFromAPI(food));

    }
    public MealsList getMealList1(String food){

         return mealsRepository.getInformationFromAPI(food);
    }
    public void addMeal(Meals meals){
        mealsRepository.insertMeal(meals);
    }
    public List<Meals> getAllMealsByDate(String date){
        listMutableLiveData.setValue(mealsRepository.getMealsForDate(date));
        return mealsRepository.getMealsForDate(date);
    }
    public void deleteMeal(Meals meals){
        mealsRepository.deleteMeal(meals);

    }
}
