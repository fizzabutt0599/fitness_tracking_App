package com.example.fitnesstrackingapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseInfoActivity extends AppCompatActivity {

    TextView exerciseNameTextView, repsTextView, durationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);

        exerciseNameTextView = findViewById(R.id.exerciseName);
        repsTextView = findViewById(R.id.reps);
        durationTextView = findViewById(R.id.duration);

        String exerciseName = getIntent().getStringExtra("exerciseName");
        String reps = getIntent().getStringExtra("reps");
        String duration = getIntent().getStringExtra("duration");

        exerciseNameTextView.setText(exerciseName);
        repsTextView.setText("Reps: " + reps);
        durationTextView.setText("Duration: " + duration);
    }
}
