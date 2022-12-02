package com.example.calorietracker.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.calorietracker.model.Meals;

import java.util.List;

@Dao
public interface MealsDAO {

    @Insert
    void insert(Meals meals);
    @Query("SELECT * FROM Meals_table WHERE Date =:date")
    LiveData< List<Meals>> getMeals(String date);

    @Query("SELECT * FROM Meals_table WHERE Date =:date")
    List<Meals> getAllMealsForDate(String date);

    @Delete
    void delete(Meals meals);





}
