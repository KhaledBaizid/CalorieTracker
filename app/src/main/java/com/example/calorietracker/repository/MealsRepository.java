package com.example.calorietracker.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.calorietracker.api.MealsApi;
import com.example.calorietracker.api.ServiceGenerator;
import com.example.calorietracker.dao.MealsDAO;
import com.example.calorietracker.database.MealsDB;
import com.example.calorietracker.model.ApiQuery;
import com.example.calorietracker.model.MealsList;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Response;

public class MealsRepository {
    private MealsApi mealsApi;
    private static MealsRepository instance;
    private MealsDAO mealsDAO;

    private MealsRepository(Application application)
    {
        MealsDB db = MealsDB.getInstance(application);
        mealsDAO = db.mealsDAO();
    }

    public static MealsRepository getInstance(Application application)
    {
        if(instance == null)
        {
            instance = new MealsRepository(application);
        }
        return instance;
    }

    public MealsList getInformationFromAPI(String foodName)
    {
        mealsApi = ServiceGenerator.getApiEndpoint();
        try
        {
            return new getMealInfoAsyncTask(mealsApi).execute(new ApiQuery(foodName)).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static class getMealInfoAsyncTask extends AsyncTask<ApiQuery,Void,MealsList>
    {
        private MealsApi asyncTaskApi;

        private getMealInfoAsyncTask(MealsApi mealsApi)
        {
            asyncTaskApi = mealsApi;
        }

        @Override
        protected MealsList doInBackground(ApiQuery... apiBodies)
        {
            Call<MealsList> call = asyncTaskApi.getFoodInformation(apiBodies[0]);
            Response<MealsList> response;
            try
            {
                response = call.execute();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return null;
            }
            return response.body();
        }
    }
}
