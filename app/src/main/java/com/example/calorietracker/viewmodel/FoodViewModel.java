package com.example.calorietracker.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.calorietracker.model.Foods;
import com.example.calorietracker.model.FoodsList;
import com.example.calorietracker.repository.FoodsRepository;
import java.util.List;

public class FoodViewModel extends AndroidViewModel {
    private FoodsRepository foodsRepository;
    private MutableLiveData<FoodsList> foods;
    private MutableLiveData <List<Foods>> listMutableLiveData;

    public FoodViewModel(@NonNull Application application) {
        super(application);
        foodsRepository = FoodsRepository.getInstance(getApplication());
        foods = new MutableLiveData<>();
        listMutableLiveData=new MutableLiveData<>();

    }
    public LiveData<List<Foods>> getListOfMealsPerDate(){

        return listMutableLiveData;
    }

    public LiveData<FoodsList> getAllFoods(){
        return foods;
    }
    public  void getFoodList(String food){
        foods.setValue(foodsRepository.getInformationFromAPI(food));

    }

    public void addFood(Foods foods){
        foodsRepository.insertFood(foods);
    }
    public List<Foods> getAllFoodsByDate(String date){
        listMutableLiveData.setValue(foodsRepository.getFoodsForDate(date));
        return foodsRepository.getFoodsForDate(date);
    }
    public void deleteFood(Foods foods){
        foodsRepository.deleteFood(foods);

    }
}
