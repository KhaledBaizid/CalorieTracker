package com.example.calorietracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.repository.MealsRepository;
import com.example.calorietracker.viewmodel.MealViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MealsRepository mealsRepository;
    private MealsList mealsList;
    private MealViewModel mealViewModel;
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealViewModel= new ViewModelProvider(this).get(MealViewModel.class);
        mealsList=mealViewModel.getMealList("chicken and egg");
        System.out.println(mealsList.getMeal(0).toString());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABB");

        calendarView=findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                //    Toast.makeText(getApplicationContext(), ""+dayOfMonth, Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub
                Date date = new Date(year - 1900, month, dayOfMonth);
                String fulldate = DateFormat.format("dd/MM/yyyy", date).toString();


               // String strDt = simpleDate.format(dayOfMonth,month,year);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("date", fulldate);
                startActivity(intent);

            }

        });

       /*  calendarView.setOnClickListener(view -> {
            Intent intent = new Intent(this, SearchCalorie.class);
            startActivity(intent);
        });*/

    }
}