package com.example.calorietracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.calorietracker.model.MealsList;
import com.example.calorietracker.repository.MealsRepository;
import com.example.calorietracker.viewmodel.MealViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;

public class CalenderActivity extends AppCompatActivity {
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;

    private MealsRepository mealsRepository;
    private MealsList mealsList;
    private MealViewModel mealViewModel;
    private CalendarView calendarView;
    private FirebaseAuth mAuth;
    private Button signOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  mAuth = FirebaseAuth.getInstance();
        mealViewModel= new ViewModelProvider(this).get(MealViewModel.class);
        calendarView=findViewById(R.id.calendarView);
        signOut= findViewById(R.id.signOut);
        googleSignInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient= GoogleSignIn.getClient(this,googleSignInOptions);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                                Date date = new Date(year - 1900, month, dayOfMonth);
                String fulldate = DateFormat.format("dd/MM/yyyy", date).toString();
                Intent intent = new Intent(CalenderActivity.this, DailyActivity.class);
                intent.putExtra("date", fulldate);
                startActivity(intent);
            }
        });
        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sign_out();
            }
        });
    }

    private void sign_out() {
        googleSignInClient.signOut().addOnCompleteListener(this,new OnCompleteListener<Void>() {
            @Override
            public void onComplete( Task<Void> task) {
               finish();
                startActivity(new Intent(CalenderActivity.this,SignInActivity.class));
            }
        });
    }


}