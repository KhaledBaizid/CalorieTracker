package com.example.calorietracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorietracker.R;
import com.example.calorietracker.model.Foods;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ViewHolder> {
   private List<Foods> foodsList;
    OnListItemClickListener listener;

   public FoodsAdapter(OnListItemClickListener listener){
       this.listener = listener;
   }

    public void setData(List<Foods> foodsList){
        this.foodsList = foodsList;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.meal_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,  int position) {

        Foods currentFoods = foodsList.get(position);
        holder.foodName.setText(currentFoods.getFood_name());
        holder.Serving.setText(String.valueOf(currentFoods.getServing_weight_grams())+" gr");
        holder.Calories.setText(String.valueOf(currentFoods.getNf_calories())+" Kcl");

    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        TextView Serving;
        TextView Calories;
        ImageView imageViewDelete;

         ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName= itemView.findViewById(R.id.item_foodname);
            Serving= itemView.findViewById(R.id.item_serving);
            Calories= itemView.findViewById(R.id.item_calories);
            imageViewDelete=itemView.findViewById(R.id.imageView_delete);
             imageViewDelete.setOnClickListener(view -> {
                 listener.onClick(getMealAt(getBindingAdapterPosition()));
             });

        }
    }

    public interface OnListItemClickListener{
        void onClick(Foods foods1);
    }

    public Foods getMealAt(int position) {
        return foodsList.get(position);
    }
}
