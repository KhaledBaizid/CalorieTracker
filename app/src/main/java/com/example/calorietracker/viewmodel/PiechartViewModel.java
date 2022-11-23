package com.example.calorietracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.model.PieChartdata;
import com.example.calorietracker.repository.MealsRepository;
import com.example.calorietracker.repository.PieChartRepository;

public class PiechartViewModel extends AndroidViewModel {
    private MutableLiveData<PieChartdata> notes;
    private PieChartRepository pieChartRepository;
  //  private MutableLiveData<MealsList> notes;

    public PiechartViewModel(@NonNull Application application) {
        super(application);
       pieChartRepository=PieChartRepository.getInstance(getApplication());
      //  notes = new MutableLiveData<>();
        MealsList newList = new MealsList();
        notes = new MutableLiveData<>();
        //notes.setValue(newList);

    }

   /* public PieChartdata getPiechartData(String date){
        return pieChartRepository.getMealsForDate(date);
    }*/
    public LiveData<PieChartdata> getAllNotes(){
        return notes;
    }
    public  void getPiechartData(String date){
       // notes.setValue(null);
       // notes.postValue(pieChartRepository.getMealsForDate(date));
       // PieChartdata pieChartdata= new PieChartdata(0,0,0);
       // notes.setValue(pieChartdata);

        notes.setValue(pieChartRepository.getMealsForDate(date));

    }

    public  PieChartdata getPiechartData1(String date){
        // notes.setValue(null);
        // notes.postValue(pieChartRepository.getMealsForDate(date));
     return   (pieChartRepository.getMealsForDate(date));

    }
}
