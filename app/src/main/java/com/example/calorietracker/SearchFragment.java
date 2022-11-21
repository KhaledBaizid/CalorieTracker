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

import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.viewmodel.MealViewModel;


public class SearchFragment extends Fragment {

    private MealViewModel mealViewModel;
    private MealsList mealsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        TextView search = (TextView) view.findViewById(R.id.search_src_text);
        Button searchButton = (Button)view.findViewById(R.id.search_button) ;


        mealViewModel= new ViewModelProvider(this).get(MealViewModel.class);
        String date=getActivity().getIntent().getStringExtra("date");


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
                   serving.setText(String.valueOf(notes.getMeal(0).getServing_weight_grams()));
                   calories.setText(String.valueOf(notes.getMeal(0).getNf_calories()));
                   protein.setText(String.valueOf(notes.getMeal(0).getNf_protein()));
                   fat.setText(String.valueOf(notes.getMeal(0).getNf_total_fat()));
                   carbs.setText(String.valueOf(notes.getMeal(0).getNf_total_carbohydrate()));
               }
           }
       });
        searchButton.setOnClickListener(view1 -> mealViewModel.getMealList(search.getText().toString()));


        return view;
    }
}