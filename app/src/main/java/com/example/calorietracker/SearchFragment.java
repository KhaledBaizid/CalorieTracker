package com.example.calorietracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.model.PieChartdata;
import com.example.calorietracker.viewmodel.MealViewModel;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    private MealViewModel mealViewModel;
    private MealsList mealsList;
    private Meals meals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        TextView search = (TextView) view.findViewById(R.id.search_src_text);
        Button searchButton = (Button)view.findViewById(R.id.search_button) ;
        Button confirmButton = (Button)view.findViewById(R.id.confirm_button) ;
        Button getMealsButton = (Button)view.findViewById(R.id.getMealsByDate_button) ;

        mealViewModel= new ViewModelProvider(this).get(MealViewModel.class);
        String date=getActivity().getIntent().getStringExtra("date");
       meals = new Meals("01/01/1900","bread",10,10,10,10,10);

        TextView foodName = (TextView) view.findViewById(R.id.foodName_text);
        TextView serving = (TextView) view.findViewById(R.id.size_text);
        TextView calories = (TextView) view.findViewById(R.id.calories_text);
        TextView protein = (TextView) view.findViewById(R.id.protein_text);
        TextView fat = (TextView) view.findViewById(R.id.fat_text);
        TextView carbs = (TextView) view.findViewById(R.id.carbs_text);

     //   mealsList=mealViewModel.getMealList(search.getText().toString());
       // foodName.setText(mealsList.getMeal(0).getFood_name());
       // serving.setText();
        // Inflate the layout for this fragment
      mealViewModel.getAllNotes().observe(getViewLifecycleOwner(), new Observer<MealsList>() {
           @Override
           public void onChanged(MealsList notes) {
               //Update UI with textView.setText()...
               if (notes !=null) {
                   foodName.setText(notes.getMeal(0).getFood_name());
                   serving.setText(String.valueOf(notes.getMeal(0).getServing_weight_grams())+ " gr");
                   calories.setText(String.valueOf(notes.getMeal(0).getNf_calories())+" Kcl");
                   protein.setText(String.valueOf(notes.getMeal(0).getNf_protein())+ " gr");
                   fat.setText(String.valueOf(notes.getMeal(0).getNf_total_fat())+ " gr");
                   carbs.setText(String.valueOf(notes.getMeal(0).getNf_total_carbohydrate())+ " gr");
                   meals.setDate(date);
                   meals.setFood_name(foodName.getText().toString());
                   meals.setServing_weight_grams(notes.getMeal(0).getServing_weight_grams());
                   meals.setNf_calories(notes.getMeal(0).getNf_calories());
                   meals.setNf_protein(notes.getMeal(0).getNf_protein());
                   meals.setNf_total_fat(notes.getMeal(0).getNf_total_fat());
                   meals.setNf_total_carbohydrate(notes.getMeal(0).getNf_total_carbohydrate());
                  /* Meals meals= new Meals(date,foodName.getText().toString(),Double.parseDouble(serving.getText().toString())
                           ,Double.parseDouble(calories.getText().toString())
                           ,Double.parseDouble(protein.getText().toString())
                           ,Double.parseDouble(fat.getText().toString())
                           ,Double.parseDouble(carbs.getText().toString()));*/
               }

           }
       });

        searchButton.setOnClickListener(view1 -> mealViewModel.getMealList(search.getText().toString()));
        confirmButton.setOnClickListener(view2 -> mealViewModel.addMeal(meals));
      //  confirmButton.setOnClickListener(view2 -> mealViewModel.addMeal(meals));
        getMealsButton.setOnClickListener(view3 -> {
                     List<Meals> m= new ArrayList<>();
                     double pieFat=0;
                     double pieCarb=0;
                     double pieProtein=0;
                    m= (mealViewModel.getAllMealsByDate(date));
                    for (Meals m1:m
                         ) {
                        pieCarb+=m1.getNf_total_carbohydrate();
                        pieFat+=m1.getNf_total_fat();
                        pieProtein+=m1.getNf_protein();
                        System.out.println(m1.toString());

                    }
                    PieChartdata p= new PieChartdata(pieFat,pieCarb,pieProtein);
                    System.out.println(p.toString());
                }
                );
        //
      //  meals.setDate(foodName.toString());
        return view;
    }
}