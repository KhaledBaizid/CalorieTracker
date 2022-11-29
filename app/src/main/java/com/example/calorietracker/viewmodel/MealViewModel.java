package com.example.calorietracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.repository.MealsRepository;

import java.util.List;

public class MealViewModel extends AndroidViewModel {
    private MealsRepository mealsRepository;
    private MutableLiveData<MealsList> notes;
    private MutableLiveData <List<Meals>> listMutableLiveData;

    public MealViewModel(@NonNull Application application) {
        super(application);
        mealsRepository=MealsRepository.getInstance(getApplication());
        notes = new MutableLiveData<>();
        listMutableLiveData=new MutableLiveData<>();
        MealsList newList = new MealsList();
        //notes.setValue(newList);

    }
    public LiveData<List<Meals>> getListOfMealsPerDate(){

        return listMutableLiveData;
    }

    public LiveData<MealsList> getAllNotes(){
        return notes;
    }
    public  void getMealList(String food){
        notes.setValue(mealsRepository.getInformationFromAPI(food));

    }
    public MealsList getMealList1(String food){
       // notes.setValue(mealsRepository.getInformationFromAPI(food));
         return mealsRepository.getInformationFromAPI(food);
    }
    public void addMeal(Meals meal){
        mealsRepository.insertMeal(meal);
    }
    public List<Meals> getAllMealsByDate(String date){
        listMutableLiveData.setValue(mealsRepository.getMealsForDate(date));
        return mealsRepository.getMealsForDate(date);
    }
    public void deleteMeal(Meals meals){
        mealsRepository.deleteMeal(meals);
      //  listMutableLiveData.setValue();
       // listMutableLiveData.setValue(););
    }
}
