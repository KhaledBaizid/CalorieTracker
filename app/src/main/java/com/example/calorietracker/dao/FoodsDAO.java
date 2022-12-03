package com.example.calorietracker.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.calorietracker.model.Foods;

import java.util.List;

@Dao
public interface FoodsDAO {

    @Insert
    void insert(Foods foods);

    @Query("SELECT * FROM Foods_table WHERE Date =:date")
    List<Foods> getAllFoodsForDate(String date);

    @Delete
    void delete(Foods foods);





}
