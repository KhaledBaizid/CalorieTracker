package com.example.calorietracker;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.calorietracker.model.PieChartdata;
import com.example.calorietracker.viewmodel.PiechartViewModel;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;


public class PiechartFragment extends Fragment {
    private PiechartViewModel piechartViewModel;
    private AnyChartView anyChartView;
    private TextView totalCalories;
    private String date;
    Pie pie;
    View view ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view  = inflater.inflate(R.layout.fragment_piechart, container, false);
        piechartViewModel= new ViewModelProvider(this).get(PiechartViewModel.class);
        anyChartView=  view.findViewById(R.id.any_chart_view);
        totalCalories= view.findViewById(R.id.totalCalories);
         pie= AnyChart.pie();
        return view;
    }

    @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

             List<DataEntry> dataEntries= new ArrayList<>();
            date=getActivity().getIntent().getStringExtra("date");
            piechartViewModel.getPiechartData(date);
            piechartViewModel.getPieChart().observe(getViewLifecycleOwner(), new Observer<PieChartdata>() {

            @Override
            public void onChanged(PieChartdata pieChartdata) {
                Formatter formatter = new Formatter();
                formatter.format("%.2f", pieChartdata.getTotalFat()+pieChartdata.getTotalProtein()+pieChartdata.getTotalCarbs());
                totalCalories.setText(formatter.toString()+" Kcl");
                dataEntries.add(new ValueDataEntry("Fat",pieChartdata.getTotalFat()));
                dataEntries.add(new ValueDataEntry("Protein",pieChartdata.getTotalProtein()));
                dataEntries.add(new ValueDataEntry("Carbs",pieChartdata.getTotalCarbs()));
                pie.data(dataEntries);
                anyChartView.setChart(pie);
            }
        });

    }

}