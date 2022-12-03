package com.example.calorietracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calorietracker.adapter.FoodsAdapter;
import com.example.calorietracker.model.Foods;
import com.example.calorietracker.viewmodel.FoodViewModel;

import java.util.List;


public class ListFragment extends Fragment implements FoodsAdapter.OnListItemClickListener{
    RecyclerView FListOfMeals;
    private FoodViewModel foodViewModel;
    private String date;
    View view ;
    FoodsAdapter foodsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        FListOfMeals= view.findViewById(R.id.rv);
        FListOfMeals.setLayoutManager(manager);
        FListOfMeals.setHasFixedSize(true);
        foodsAdapter = new FoodsAdapter(this);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        date=getActivity().getIntent().getStringExtra("date");
        foodViewModel.getAllFoodsByDate(date);
        foodViewModel.getListOfMealsPerDate().observe(getViewLifecycleOwner(), new Observer<List<Foods>>() {
          @Override
          public void onChanged(List<Foods> meals) {
              foodsAdapter.setData(meals);
              FListOfMeals.setAdapter(foodsAdapter);
          }
      }
      );
        return view;
    }

    @Override
    public void onClick(Foods foods1) {
        foodViewModel.deleteFood(foods1);
        foodViewModel.getAllFoodsByDate(date);
    }
}