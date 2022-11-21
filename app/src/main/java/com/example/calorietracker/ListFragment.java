package com.example.calorietracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class ListFragment extends Fragment {

//private EditText selectedDate1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String date=getActivity().getIntent().getStringExtra("date");
        View view = inflater.inflate(R.layout.fragment_list, container, false);
      //  EditText editText = (EditText) view.findViewById(R.id.searchTextFragment);
        //editText.setText(date);

      //  selectedDate=getActivity().getIntent().findViewById(R.id.selectedDate);


        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }
}