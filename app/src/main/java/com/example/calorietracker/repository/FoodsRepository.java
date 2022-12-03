package com.example.calorietracker.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.calorietracker.api.FoodsApi;
import com.example.calorietracker.api.ServiceGenerator;
import com.example.calorietracker.dao.FoodsDAO;
import com.example.calorietracker.database.FoodsDB;
import com.example.calorietracker.model.ApiQuery;
import com.example.calorietracker.model.Foods;
import com.example.calorietracker.model.FoodsList;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Response;

public class FoodsRepository {
    private FoodsApi foodsApi;
    private static FoodsRepository instance;
    private FoodsDAO foodsDAO;

    private FoodsRepository(Application application)
    {
        FoodsDB db = FoodsDB.getInstance(application);
        foodsDAO = db.foodsDAO();
    }

    public static FoodsRepository getInstance(Application application)
    {
        if(instance == null)
        {
            instance = new FoodsRepository(application);
        }
        return instance;
    }

    public FoodsList getInformationFromAPI(String foodName)
    {
        foodsApi = ServiceGenerator.getApiEndpoint();
        try
        {
            return new getFoodInfoAsyncTask(foodsApi).execute(new ApiQuery(foodName)).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static class getFoodInfoAsyncTask extends AsyncTask<ApiQuery,Void, FoodsList>
    {
        private FoodsApi asyncTaskApi;

        private getFoodInfoAsyncTask(FoodsApi foodsApi)
        {
            asyncTaskApi = foodsApi;
        }

        @Override
        protected FoodsList doInBackground(ApiQuery... apiBodies)
        {
            Call<FoodsList> call = asyncTaskApi.getFoodInformation(apiBodies[0]);
            Response<FoodsList> response;
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

    public void insertFood(Foods foods)
    {
        new InsertFoodAsyncTask(foodsDAO).execute(foods);
    }

    private static class InsertFoodAsyncTask extends AsyncTask<Foods, Void, Void>
    {
        private FoodsDAO foodsDao;

        private InsertFoodAsyncTask(FoodsDAO foodsDao)
        {
            this.foodsDao = foodsDao;
        }

        @Override
        protected Void doInBackground(Foods... foods)
        {
            foodsDao.insert(foods[0]);
            return null;
        }
    }


    public List<Foods> getFoodsForDate(String date)
    {
        try
        {
            return new GetFoodsForDateAsyncTask(foodsDAO).execute(date).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static class GetFoodsForDateAsyncTask extends AsyncTask<String, Void, List<Foods>> {
        private FoodsDAO foodsDao;

        private GetFoodsForDateAsyncTask(FoodsDAO foodsDao) {
            this.foodsDao = foodsDao;
        }

        @Override
        protected List<Foods> doInBackground(String... strings) {
            return foodsDao.getAllFoodsForDate(strings[0]);
        }
    }


    //////////////////////

    public void deleteFood(Foods foods)
    {
        new DeleteFoodAsyncTask(foodsDAO).execute(foods);
    }

    private static class DeleteFoodAsyncTask extends AsyncTask<Foods, Void, Void>
    {
        private FoodsDAO foodsDao;

        private DeleteFoodAsyncTask(FoodsDAO foodsDao)
        {
            this.foodsDao = foodsDao;
        }

        @Override
        protected Void doInBackground(Foods... food)
        {
            foodsDao.delete(food[0]);
            return null;
        }
    }
}
