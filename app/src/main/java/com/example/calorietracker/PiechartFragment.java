package com.example.calorietracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.calorietracker.model.PieChartdata;
import com.example.calorietracker.viewmodel.MealViewModel;
import com.example.calorietracker.viewmodel.PiechartViewModel;

import java.util.ArrayList;
import java.util.List;


public class PiechartFragment extends Fragment {
    //private PiechartViewModel piechartViewModel;
  //  private AnyChartView anyChartView;
    String date;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        date=getActivity().getIntent().getStringExtra("date");
        View view = inflater.inflate(R.layout.fragment_piechart, container, false);
       // piechartViewModel= new ViewModelProvider(this).get(PiechartViewModel.class);
        AnyChartView anyChartView= view.findViewById(R.id.any_chart_view);
        Pie pie= AnyChart.pie();
        List<DataEntry> dataEntries= new ArrayList<>();
        dataEntries.add(new ValueDataEntry("Fat",100));
        dataEntries.add(new ValueDataEntry("Protein",100));
        dataEntries.add(new ValueDataEntry("Carbs",100));
        pie.data(dataEntries);

        anyChartView.setChart(pie);
       // setUpPie();


        return view;
    }
    public void setUpPie(){
        PieChartdata pieChartdata= new PieChartdata(50,100,28);
       // PieChartdata pieChartdata1= piechartViewModel.getPiechartData(date);


        Pie pie= AnyChart.pie();
        List<DataEntry> dataEntries= new ArrayList<>();
       // dataEntries.add(new ValueDataEntry("Fat",pieChartdata.getTotalFat()));
       // dataEntries.add(new ValueDataEntry("Protein",pieChartdata.getTotalProtein()));
       // dataEntries.add(new ValueDataEntry("Carbs",pieChartdata.getTotalCarbs()));

        dataEntries.add(new ValueDataEntry("Fat",100));
        dataEntries.add(new ValueDataEntry("Protein",100));
        dataEntries.add(new ValueDataEntry("Carbs",100));
        pie.data(dataEntries);

        //anyChartView.setChart(pie);
    }
}