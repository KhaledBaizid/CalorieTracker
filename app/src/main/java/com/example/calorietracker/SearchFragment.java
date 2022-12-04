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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.calorietracker.model.Foods;
import com.example.calorietracker.model.FoodsList;
import com.example.calorietracker.viewmodel.FoodViewModel;
import com.example.calorietracker.viewmodel.PiechartViewModel;


public class SearchFragment extends Fragment {

    private FoodViewModel foodViewModel;
    private PiechartViewModel piechartViewModel;
    private Foods foods;
    private EditText search;
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
         search =  view.findViewById(R.id.search_src_text);
        confirmImageView= view.findViewById(R.id.imageView_confirm);
        searchImageView= view.findViewById(R.id.imageView_search);
        piechartViewModel= new ViewModelProvider(this).get(PiechartViewModel.class);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        String date=getActivity().getIntent().getStringExtra("date");
        foods = new Foods();
        foodName =  view.findViewById(R.id.foodName_text);
        serving =  view.findViewById(R.id.size_text);
        calories =  view.findViewById(R.id.calories_text);
        protein =  view.findViewById(R.id.protein_text);
        fat =  view.findViewById(R.id.fat_text);
        carbs =  view.findViewById(R.id.carbs_text);

      foodViewModel.getAllFoods().observe(getViewLifecycleOwner(), new Observer<FoodsList>() {
           @Override
           public void onChanged(FoodsList food) {

               if (food !=null) {
                   foodName.setText(food.getFood(0).getFood_name());
                   serving.setText(String.valueOf(food.getFood(0).getServing_weight_grams())+ " gr");
                   calories.setText(String.valueOf(food.getFood(0).getNf_calories())+" Kcl");
                   protein.setText(String.valueOf(food.getFood(0).getNf_protein())+ " gr");
                   fat.setText(String.valueOf(food.getFood(0).getNf_total_fat())+ " gr");
                   carbs.setText(String.valueOf(food.getFood(0).getNf_total_carbohydrate())+ " gr");
                   foods.setDate(date);
                   foods.setFood_name(foodName.getText().toString().substring(0,1).toUpperCase()+foodName.getText().toString().substring(1));
                   foods.setServing_weight_grams(food.getFood(0).getServing_weight_grams());
                   foods.setNf_calories(food.getFood(0).getNf_calories());
                   foods.setNf_protein(food.getFood(0).getNf_protein());
                   foods.setNf_total_fat(food.getFood(0).getNf_total_fat());
                   foods.setNf_total_carbohydrate(food.getFood(0).getNf_total_carbohydrate());
               }
           }
       });

        searchImageView.setOnClickListener(view1 -> foodViewModel.getFoodList(search.getText().toString()));
        confirmImageView.setOnClickListener(view2 -> {
            foodViewModel.addFood(foods);
            foods=new Foods();
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