package com.example.calorietracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.model.PieChartdata;
import com.example.calorietracker.viewmodel.MealViewModel;
import com.example.calorietracker.viewmodel.PiechartViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PiechartFragment extends Fragment {
    private PiechartViewModel piechartViewModel;
    private AnyChartView anyChartView;
    private PieChartdata pieChartdata;
    private String date;
    Pie pie;
    View view ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            view  = inflater.inflate(R.layout.fragment_piechart, container, false);



        piechartViewModel= new ViewModelProvider(this).get(PiechartViewModel.class);



            anyChartView= (AnyChartView) view.findViewById(R.id.any_chart_view);




pie= AnyChart.pie();
        return view;
    }
        ///////

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);


        // Inflate the layout for this fragment
       //String  date=getActivity().getIntent().getStringExtra("date");
           // PieChartdata pieChartdata= new PieChartdata(0,0,0);


        //piechartViewModel= new ViewModelProvider(this).get(PiechartViewModel.class);
        //AnyChartView anyChartView= (AnyChartView) view.findViewById(R.id.any_chart_view);

      //  PieChartdata pieChartdata= new PieChartdata(0,0,0);
        //anyChartView.clear();
      /*  PieChartdata pieChartdata1= piechartViewModel.getPiechartData1(date);

        Pie pie= AnyChart.pie();
        List<DataEntry> dataEntries= new ArrayList<>();
        dataEntries.add(new ValueDataEntry("Fat",pieChartdata1.getTotalFat()));
        dataEntries.add(new ValueDataEntry("Protein",pieChartdata1.getTotalProtein()));
        dataEntries.add(new ValueDataEntry("Carbs",pieChartdata1.getTotalCarbs()));
        pie.data(dataEntries);
        anyChartView.setChart(pie);
        anyChartView.invalidate();*/
        //setUpPie(date);

        List<DataEntry> dataEntries= new ArrayList<>();


            pieChartdata= new PieChartdata(0,0,0);
            date=getActivity().getIntent().getStringExtra("date");

           // piechartViewModel.getPiechartData(date);

        piechartViewModel.getPiechartData(date);
        /////////////////////////////////////
        piechartViewModel.getAllNotes().observe(getViewLifecycleOwner(), new Observer<PieChartdata>() {

            @Override
            public void onChanged(PieChartdata notes) {


                //Update UI with textView.setText()...
               // if (anyChartView.getTop()){
               // anyChartView.removeViewAt(anyChartView.getTop());
               // if (true) {
                  //  dataEntries.clear();
              // anyChartView.invalidateOutline();



                dataEntries.add(new ValueDataEntry("Fat",notes.getTotalFat()));
                    dataEntries.add(new ValueDataEntry("Protein",notes.getTotalProtein()));
                    dataEntries.add(new ValueDataEntry("Carbs",notes.getTotalCarbs()));


                pie.data(dataEntries);
                    anyChartView.setChart(pie);

                   // anyChartView.invalidate();
               // }

            }
        });
        ///////////////////////////////////
        System.out.println(date);
        System.out.println(date);
        System.out.println(date);


       // return view;
    }
  //  public void setUpPie(String date){
   //     PieChartdata pieChartdata= new PieChartdata(0,0,0);
        //PieChartdata pieChartdata1= piechartViewModel.getPiechartData(date);
    //    piechartViewModel.getPiechartData(date);
    //    Pie pie= AnyChart.pie();
     //   List<DataEntry> dataEntries= new ArrayList<>();
       // dataEntries.add(new ValueDataEntry("Fat",pieChartdata1.getTotalFat()));
      ////  dataEntries.add(new ValueDataEntry("Protein",pieChartdata1.getTotalProtein()));
       // dataEntries.add(new ValueDataEntry("Carbs",pieChartdata1.getTotalCarbs()));
      //  pie.data(dataEntries);
        //anyChartView.setChart(pie);
    //}
}