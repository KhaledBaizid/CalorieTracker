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
   // private View.OnClickListener onClickListener;
    private MealsRepository mealsRepository;
    private OnClickListener onClickListener;
  //  OnListItemClickListner listner;
  //  Context application = null;
  // final  MealsDB db = MealsDB.getInstance(application);
  // final MealsDAO mealsDAO = db.mealsDAO();
    //private PiechartViewModel mealViewModel;

   MealsAdapter(List<Meals> mealsList) {
        this.mealsList = mealsList;
     //  this.OnListItemClickListner=OnListItemClickListner;



    }
    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = listener;
    }
    /*
    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = (View.OnClickListener) listener;
    }*/


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.meal_list_item, parent, false);

       // mealsRepository = new MealsRepository.getInstance(MealsDB.getInstance());
       // mealViewModel= new ViewModelProvider((ViewModelStoreOwner) this).get(MealViewModel.class);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,  int position) {
     //holder.itemView.
        //mealViewModel= new ViewModelProvider((ViewModelStoreOwner) this).get(PiechartViewModel.class);
        Meals currentMeal= mealsList.get(position);
        holder.foodName.setText(currentMeal.getFood_name());
        holder.Serving.setText(String.valueOf(currentMeal.getServing_weight_grams())+" gr");
        holder.Calories.setText(String.valueOf(currentMeal.getNf_calories())+" Kcl");



       /* holder.delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               // Meals theRemovedItem = mealsList.get(position);
                // remove your item from data base
                System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
              //  mealsDAO.delete(currentMeal);
              //  mealsList.remove(currentMeal);  // remove the item from list
              //  notifyItemRemoved(mealsList.get(getBindingAdapterPosition())); // notify the adapter about the removed item
            }
        });*/

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName= itemView.findViewById(R.id.item_foodname);
            Serving= itemView.findViewById(R.id.item_serving);
            Calories= itemView.findViewById(R.id.item_calories);
            delete=itemView.findViewById(R.id.item_delete);

            itemView.setOnClickListener(v -> {
                onClickListener.onClick(mealsList.get(getBindingAdapterPosition()));
            });
           // itemView.setOnClickListener(v -> {
            //   onClickListener.onClick(mealsList.get(getBindingAdapterPosition()));
          //  });
           delete.setOnClickListener(view -> {
                onClickListener.onClick(getMealAt(getBindingAdapterPosition()));
            });
        }
    }

    public interface OnClickListener {
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
