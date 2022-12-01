package com.example.calorietracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.viewmodel.MealViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ListFragment extends Fragment implements MealsAdapter.OnListItemClickListener{
    RecyclerView FListOfMeals;
    private MealViewModel mealViewModel;
    private String date;
    View view ;
     MealsAdapter mealsAdapter;
     private Button deleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_list, container, false);
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        FListOfMeals= view.findViewById(R.id.rv);
        FListOfMeals.setLayoutManager(manager);
        FListOfMeals.setHasFixedSize(true);
        mealsAdapter= new MealsAdapter(this);

        mealViewModel= new ViewModelProvider(this).get(MealViewModel.class);
        date=getActivity().getIntent().getStringExtra("date");
        List<Meals> meals = new ArrayList<>();

        meals=mealViewModel.getAllMealsByDate(date);


      mealViewModel.getListOfMealsPerDate().observe(getViewLifecycleOwner(), new Observer<List<Meals>>() {
          @Override
          public void onChanged(List<Meals> meals) {
              mealsAdapter.setData(meals);
              FListOfMeals.setAdapter(mealsAdapter);



          }
      }


      );




        return view;
    }



    @Override
    public void onClick(Meals meals1) {
        System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
        System.out.println(meals1.toString());
        mealViewModel.deleteMeal(meals1);
        mealViewModel.getAllMealsByDate(date);
    }
}