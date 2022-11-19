package com.example.calorietracker.dao;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.calorietracker.model.Meals;

import java.util.List;

@Dao
public interface MealsDAO {

    @Insert
    void insert(Meals meal);
    @Query("SELECT * FROM Meals_table WHERE Date LIKE :date || '%'")
    LiveData< List<Meals>> getMeals(String date);



}
