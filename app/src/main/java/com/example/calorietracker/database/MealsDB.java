package com.example.calorietracker.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.calorietracker.dao.MealsDAO;
import com.example.calorietracker.model.Meals;

@Database(entities = {Meals.class}, version = 2)
public abstract class MealsDB extends RoomDatabase {
    private static MealsDB INSTANCE;

    public abstract MealsDAO mealsDAO();

    public static synchronized MealsDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MealsDB.class, "Meals_DataBase")

                    .build();
        }
        return INSTANCE;
    }

}
