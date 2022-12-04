package com.example.calorietracker.repository;

import android.app.Application;
import android.os.AsyncTask;
import com.example.calorietracker.dao.FoodsDAO;
import com.example.calorietracker.database.FoodsDB;
import com.example.calorietracker.model.Foods;
import com.example.calorietracker.model.PieChartdata;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PieChartRepository {
    private static PieChartRepository instance;
    private FoodsDAO foodsDAO;

    private PieChartRepository(Application application)
    {
        FoodsDB db = FoodsDB.getInstance(application);
        foodsDAO = db.foodsDAO();
    }

    public static PieChartRepository getInstance(Application application)
    {
        if(instance == null)
        {
            instance = new PieChartRepository(application);
        }
        return instance;
    }


    public PieChartdata getFoodsForDate(String date)
    {    double pieFat=0;
        double pieCarb=0;
        double pieProtein=0;
        try
        {
            List<Foods> foods=  new PieChartRepository.GetFoodsForDateAsyncTask(foodsDAO).execute(date).get();
            for (Foods f:foods
                 ) {
                pieCarb+=f.getNf_total_carbohydrate();
                pieFat+=f.getNf_total_fat();
                pieProtein+=f.getNf_protein();
            }
            return new PieChartdata(pieFat,pieCarb,pieProtein);
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
}
