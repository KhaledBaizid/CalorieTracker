package com.example.calorietracker.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.calorietracker.api.MealsApi;
import com.example.calorietracker.dao.MealsDAO;
import com.example.calorietracker.database.MealsDB;
import com.example.calorietracker.model.Meals;
import com.example.calorietracker.model.PieChartdata;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class PieChartRepository {
    private MealsApi mealsApi;
    private static PieChartRepository instance;
    private MealsDAO mealsDAO;

    private PieChartRepository(Application application)
    {
        MealsDB db = MealsDB.getInstance(application);
        mealsDAO = db.mealsDAO();
    }

    public static PieChartRepository getInstance(Application application)
    {
        if(instance == null)
        {
            instance = new PieChartRepository(application);
        }
        return instance;
    }


    public PieChartdata getMealsForDate(String date)
    {    double pieFat=0;
        double pieCarb=0;
        double pieProtein=0;
        try
        {
            List<Meals> meals=  new PieChartRepository.GetMealsForDateAsyncTask(mealsDAO).execute(date).get();
            for (Meals m:meals
                 ) {
                pieCarb+=m.getNf_total_carbohydrate();
                pieFat+=m.getNf_total_fat();
                pieProtein+=m.getNf_protein();
            }
            return new PieChartdata(pieFat,pieCarb,pieProtein);
        }
        catch (ExecutionException | InterruptedException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static class GetMealsForDateAsyncTask extends AsyncTask<String, Void, List<Meals>> {
        private MealsDAO mealsDao;

        private GetMealsForDateAsyncTask(MealsDAO mealsDao) {
            this.mealsDao = mealsDao;
        }

        @Override
        protected List<Meals> doInBackground(String... strings) {
            return mealsDao.getAllMealsForDate(strings[0]);
        }
    }
}
