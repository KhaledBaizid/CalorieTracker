package com.example.calorietracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.model.PieChartdata;
import com.example.calorietracker.repository.MealsRepository;
import com.example.calorietracker.repository.PieChartRepository;

public class PiechartViewModel extends AndroidViewModel {

    private PieChartRepository pieChartRepository;
  //  private MutableLiveData<MealsList> notes;

    public PiechartViewModel(@NonNull Application application) {
        super(application);
       pieChartRepository=PieChartRepository.getInstance(getApplication());
      //  notes = new MutableLiveData<>();
        MealsList newList = new MealsList();
        //notes.setValue(newList);

    }

    public PieChartdata getPiechartData(String date){
        return pieChartRepository.getMealsForDate(date);
    }
}
