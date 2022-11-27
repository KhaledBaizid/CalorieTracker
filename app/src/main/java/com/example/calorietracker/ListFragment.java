package com.example.calorietracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.viewmodel.MealViewModel;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {
    RecyclerView FListOfMeals;
    private MealViewModel mealViewModel;
    private String date;
    View view ;
     MealsAdapter mealsAdapter;
//private EditText selectedDate1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_list, container, false);
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        FListOfMeals= view.findViewById(R.id.rv);
        FListOfMeals.setLayoutManager(manager);
        FListOfMeals.setHasFixedSize(true);

        mealViewModel= new ViewModelProvider(this).get(MealViewModel.class);
        date=getActivity().getIntent().getStringExtra("date");
        List<Meals> meals = new ArrayList<>();
        meals=mealViewModel.getAllMealsByDate(date);
        for (Meals m1:meals
        ) {
            // pieCarb+=m1.getNf_total_carbohydrate();
            // pieFat+=m1.getNf_total_fat();
            // pieProtein+=m1.getNf_protein();
            System.out.println(m1.toString());
        }
        System.out.println(date);
        System.out.println(date);
        System.out.println(date);
        System.out.println(date);
        System.out.println(date);


      //  List<Meals> meals = new ArrayList<>();
        meals=mealViewModel.getAllMealsByDate(date);
        for (Meals m1:meals
        ) {
            // pieCarb+=m1.getNf_total_carbohydrate();
            // pieFat+=m1.getNf_total_fat();
            // pieProtein+=m1.getNf_protein();
            System.out.println(m1.toString());

        }
        mealsAdapter=new MealsAdapter(meals);
      FListOfMeals.setAdapter(mealsAdapter);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}