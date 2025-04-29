package com.example.fitnesstrackingapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Step Counter
    public void openStepCounter(View view) {
        Intent intent = new Intent(MainActivity.this, StepCounterActivity.class);
        startActivity(intent);
    }

    // Water Tracker
    public void openWaterTracker(View view) {
        Intent intent = new Intent(MainActivity.this, WaterTrackerActivity.class);
        startActivity(intent);
    }

    // Calorie Tracker
    public void openCalorieTracker(View view) {
        Intent intent = new Intent(MainActivity.this, CalorieTrackerActivity.class);
        startActivity(intent);
    }

    // BMI Calculator
    public void openBMICalculator(View view) {
        Intent intent = new Intent(MainActivity.this, BMICalculatorActivity.class);
        startActivity(intent);
    }

    // Workout Plans
    public void openWorkoutPlans(View view) {
        Intent intent = new Intent(MainActivity.this, WorkoutPlansActivity.class);
        startActivity(intent);
    }
    public void openExerciseCategories(View view) {
        Intent intent = new Intent(this, ExerciseCategoriesActivity.class);
        startActivity(intent);
    }

}
