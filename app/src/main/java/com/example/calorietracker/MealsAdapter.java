package com.example.calorietracker;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorietracker.dao.MealsDAO;
import com.example.calorietracker.database.MealsDB;
import com.example.calorietracker.model.Meals;
import com.example.calorietracker.repository.MealsRepository;
import com.example.calorietracker.viewmodel.MealViewModel;
import com.example.calorietracker.viewmodel.PiechartViewModel;

import java.util.ArrayList;
import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {
   private List<Meals> mealsList;
    private Context context;

    private MealsRepository mealsRepository;
   // private OnClickListener onClickListener;
    OnListItemClickListener listener;


   MealsAdapter(OnListItemClickListener listener){
       this.listener = listener;
   }

   /* public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = listener;
    }*/
    public void setData(List<Meals> mealsList ){
        this.mealsList = mealsList;
        notifyDataSetChanged();

    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.meal_list_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,  int position) {

        Meals currentMeal= mealsList.get(position);
        holder.foodName.setText(currentMeal.getFood_name());
        holder.Serving.setText(String.valueOf(currentMeal.getServing_weight_grams())+" gr");
        holder.Calories.setText(String.valueOf(currentMeal.getNf_calories())+" Kcl");

    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        TextView Serving;
        TextView Calories;
        Button delete;

         ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName= itemView.findViewById(R.id.item_foodname);
            Serving= itemView.findViewById(R.id.item_serving);
            Calories= itemView.findViewById(R.id.item_calories);
            delete=itemView.findViewById(R.id.item_delete);
             delete.setOnClickListener(view -> {
                 listener.onClick(getMealAt(getBindingAdapterPosition()));
             });

          /*  itemView.setOnClickListener(v -> {
                onClickListener.onClick(mealsList.get(getBindingAdapterPosition()));
            });*/
           // itemView.setOnClickListener(v -> {
            //   onClickListener.onClick(mealsList.get(getBindingAdapterPosition()));
          //  });
          // delete.setOnClickListener(view -> {
            //    onClickListener.onClick(getMealAt(getBindingAdapterPosition()));
           // });
        }
    }

  /*  public interface OnClickListener {
        void onClick(Meals meals1);
    }*/

    public interface OnListItemClickListener{
        void onClick(Meals meals1);
    }

    public void setMealsList(List<Meals> mealsList) {
        this.mealsList = mealsList;
        notifyDataSetChanged();
    }
    public Meals getMealAt(int position) {
        return mealsList.get(position);
    }
}
