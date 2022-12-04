package com.example.calorietracker.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.calorietracker.dao.FoodsDAO;
import com.example.calorietracker.model.Foods;

@Database(entities = {Foods.class}, version = 2)
public abstract class FoodsDB extends RoomDatabase {
    private static FoodsDB INSTANCE;

    public abstract FoodsDAO foodsDAO();

    public static synchronized FoodsDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FoodsDB.class, "Foods_DataBase")

                    .build();
        }
        return INSTANCE;
    }

}
