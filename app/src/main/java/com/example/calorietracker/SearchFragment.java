package com.example.calorietracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.viewmodel.MealViewModel;
import com.example.calorietracker.viewmodel.PiechartViewModel;


public class SearchFragment extends Fragment {

    private MealViewModel mealViewModel;
    private PiechartViewModel piechartViewModel;
    private MealsList mealsList;
    private Meals meals;

    private EditText search;
    private Button searchButton;
    private Button confirmButton;
    private ImageView confirmImageView,searchImageView;
    private TextView foodName,serving,calories,protein,fat,carbs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         search = (EditText) view.findViewById(R.id.search_src_text);
        confirmImageView= view.findViewById(R.id.imageView_confirm);
        searchImageView= view.findViewById(R.id.imageView_search);
        piechartViewModel= new ViewModelProvider(this).get(PiechartViewModel.class);
        mealViewModel= new ViewModelProvider(this).get(MealViewModel.class);
        String date=getActivity().getIntent().getStringExtra("date");
        meals = new Meals();
        foodName =  view.findViewById(R.id.foodName_text);
        serving =  view.findViewById(R.id.size_text);
        calories =  view.findViewById(R.id.calories_text);
        protein =  view.findViewById(R.id.protein_text);
        fat =  view.findViewById(R.id.fat_text);
        carbs =  view.findViewById(R.id.carbs_text);

      mealViewModel.getAllMeals().observe(getViewLifecycleOwner(), new Observer<MealsList>() {
           @Override
           public void onChanged(MealsList meal) {

               if (meal !=null) {
                   foodName.setText(meal.getMeal(0).getFood_name());
                   serving.setText(String.valueOf(meal.getMeal(0).getServing_weight_grams())+ " gr");
                   calories.setText(String.valueOf(meal.getMeal(0).getNf_calories())+" Kcl");
                   protein.setText(String.valueOf(meal.getMeal(0).getNf_protein())+ " gr");
                   fat.setText(String.valueOf(meal.getMeal(0).getNf_total_fat())+ " gr");
                   carbs.setText(String.valueOf(meal.getMeal(0).getNf_total_carbohydrate())+ " gr");
                   meals.setDate(date);
                   meals.setFood_name(foodName.getText().toString().substring(0,1).toUpperCase()+foodName.getText().toString().substring(1));
                   meals.setServing_weight_grams(meal.getMeal(0).getServing_weight_grams());
                   meals.setNf_calories(meal.getMeal(0).getNf_calories());
                   meals.setNf_protein(meal.getMeal(0).getNf_protein());
                   meals.setNf_total_fat(meal.getMeal(0).getNf_total_fat());
                   meals.setNf_total_carbohydrate(meal.getMeal(0).getNf_total_carbohydrate());
               }
           }
       });

        searchImageView.setOnClickListener(view1 -> mealViewModel.getMealList(search.getText().toString()));
        confirmImageView.setOnClickListener(view2 -> {
            mealViewModel.addMeal(meals);
            piechartViewModel.getPiechartData(date);
             cleanText();
        });
    }

    private void cleanText() {
        foodName.setText("");
        serving.setText("");
        calories.setText("");
        protein.setText("");
        fat.setText("");
        carbs.setText("");
        search.setText("");
    }
}