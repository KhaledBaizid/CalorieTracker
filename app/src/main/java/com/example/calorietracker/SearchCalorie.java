package com.example.calorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SearchCalorie extends AppCompatActivity {
     private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchcalorie);

        String date=getIntent().getStringExtra("date");
        editText=findViewById(R.id.editText);
        editText.setText(date);
    }


}