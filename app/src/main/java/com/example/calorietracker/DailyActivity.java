package com.example.calorietracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DailyActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ListFragment listFragment= new ListFragment();
    SearchFragment searchFragment= new SearchFragment();
    PiechartFragment piechartFragment= new PiechartFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        String date=getIntent().getStringExtra("date");
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,listFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.list: {

                         piechartFragment=null;
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,listFragment).commit();
                         return true;}
                    case R.id.search: {
                        piechartFragment=null;
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit();
                    }
                         return true;
                    case R.id.piechart: {

                        if (piechartFragment==null) {
                            piechartFragment = new PiechartFragment();
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,piechartFragment).commit();
                         return true;}
                }
                return false;
            }
        });

        Intent intent2 = new Intent(DailyActivity.this,ListFragment.class);
        intent2.putExtra("date", date);
    }
}