package com.example.fitnesstrackingapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WaterTrackerActivity extends AppCompatActivity {

    private ProgressBar waterProgressBar;
    private TextView tvWaterAmount;
    private Button btnAddWater;
    private int totalWater = 0;
    private final int maxWater = 3000; // ml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_tracker);

        waterProgressBar = findViewById(R.id.waterProgressBar);
        tvWaterAmount = findViewById(R.id.tvWaterAmount);
        btnAddWater = findViewById(R.id.btnAddWater);

        // Load saved progress
        SharedPreferences prefs = getSharedPreferences("WaterPrefs", MODE_PRIVATE);
        totalWater = prefs.getInt("totalWater", 0);
        updateProgress();

        btnAddWater.setOnClickListener(v -> {
            if (totalWater < maxWater) {
                totalWater += 250;
                if (totalWater > maxWater) totalWater = maxWater;

                // Save progress
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("totalWater", totalWater);
                editor.apply();

                updateProgress();
            }
        });
    }

    private void updateProgress() {
        waterProgressBar.setProgress(totalWater);
        tvWaterAmount.setText(totalWater + " ml / " + maxWater + " ml");
    }
}
