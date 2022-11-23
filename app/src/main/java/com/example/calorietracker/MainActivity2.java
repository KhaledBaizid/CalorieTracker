package com.example.calorietracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {
    // EditText selectedDate;
    BottomNavigationView bottomNavigationView;
    ListFragment listFragment= new ListFragment();
    SearchFragment searchFragment= new SearchFragment();
    PiechartFragment piechartFragment= new PiechartFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ///
        String date=getIntent().getStringExtra("date");
       // selectedDate=findViewById(R.id.selectedDate);
      //  selectedDate.setText(date);
        ///
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

                       /* Fragment fragment= getSupportFragmentManager().findFragmentByTag("piechartFragment");
                        if (fragment!=null){
                            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                            transaction.remove(piechartFragment);
                            transaction.commitNow();
                        }*/
                      //  FragmentTransaction transaction1= getSupportFragmentManager().beginTransaction();

                          //transaction1.replace(R.id.container,piechartFragment);
                        //  transaction1.remove(piechartFragment);
                        //  transaction1.commitNow();

                      // FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();

                      //  transaction.replace(R.id.container,piechartFragment);
                      //  transaction.commit();
                       // if(item.getItemId())
                        piechartFragment= new PiechartFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,piechartFragment).commit();
                         return true;}
                }
                return false;
            }
        });

        Intent intent2 = new Intent(MainActivity2.this,ListFragment.class);
        intent2.putExtra("date", date);
    }
}