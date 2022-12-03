package com.example.calorietracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.calorietracker.model.PieChartdata;
import com.example.calorietracker.repository.PieChartRepository;

public class PiechartViewModel extends AndroidViewModel {
    private MutableLiveData<PieChartdata> pieChartdataMutableLiveData;
    private PieChartRepository pieChartRepository;


    public PiechartViewModel(@NonNull Application application) {
        super(application);
       pieChartRepository=PieChartRepository.getInstance(getApplication());
        pieChartdataMutableLiveData = new MutableLiveData<>();

    }


    public LiveData<PieChartdata> getPieChart(){
        return pieChartdataMutableLiveData;
    }
    public  void getPiechartData(String date){
        pieChartdataMutableLiveData.setValue(pieChartRepository.getFoodsForDate(date));
    }

}
