package com.example.calorietracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorietracker.model.Meals;

import java.util.ArrayList;
import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {
   private List<Meals> mealsList;
    private View.OnClickListener onClickListener;

   MealsAdapter(List<Meals> mealsList) {
        this.mealsList = mealsList;
    }
    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = (View.OnClickListener) listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.meal_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     //holder.itemView.
        holder.foodName.setText(mealsList.get(position).getFood_name());
        holder.Serving.setText(String.valueOf(mealsList.get(position).getServing_weight_grams())+" gr");
        holder.Calories.setText(String.valueOf(mealsList.get(position).getNf_calories())+" Kcl");
    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        TextView Serving;
        TextView Calories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName= itemView.findViewById(R.id.item_foodname);
            Serving= itemView.findViewById(R.id.item_serving);
            Calories= itemView.findViewById(R.id.item_calories);
         //   itemView.setOnClickListener(v -> {
            //   onClickListener.onClick(mealsList.get(getBindingAdapterPosition()));
           // });
        }
    }

    public interface OnClickListener {
        void onClick(Meals meals);
    }
}
