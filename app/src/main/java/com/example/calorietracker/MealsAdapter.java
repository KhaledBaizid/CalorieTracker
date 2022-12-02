package com.example.calorietracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorietracker.model.Meals;
import com.example.calorietracker.repository.MealsRepository;

import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {
   private List<Meals> mealsList;
    private Context context;
    OnListItemClickListener listener;

   MealsAdapter(OnListItemClickListener listener){
       this.listener = listener;
   }

    public void setData(List<Meals> mealsList){
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

        Meals currentMeals = mealsList.get(position);
        holder.foodName.setText(currentMeals.getFood_name());
        holder.Serving.setText(String.valueOf(currentMeals.getServing_weight_grams())+" gr");
        holder.Calories.setText(String.valueOf(currentMeals.getNf_calories())+" Kcl");

    }

    @Override
    public int getItemCount() {
        return mealsList.size();
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
        void onClick(Meals meals1);
    }

    public Meals getMealAt(int position) {
        return mealsList.get(position);
    }
}
