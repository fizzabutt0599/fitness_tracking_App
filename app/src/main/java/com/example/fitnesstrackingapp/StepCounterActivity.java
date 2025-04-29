package com.example.fitnesstrackingapp;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class StepCounterActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor stepCounterSensor;
    private TextView tvStepCount;
    private Button btnStartStop;
    private boolean isTracking = false;
    private int stepCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        tvStepCount = findViewById(R.id.tvStepCount);
        btnStartStop = findViewById(R.id.btnStartStop);

        // Get the sensor system service
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        // Handle Start/Stop button click
        btnStartStop.setOnClickListener(v -> {
            if (isTracking) {
                stopTracking();
            } else {
                startTracking();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the sensor when the activity is resumed
        if (stepCounterSensor != null) {
            sensorManager.registerListener(this, stepCounterSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the sensor when the activity is paused
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            // If tracking, update the step count
            if (isTracking) {
                stepCount = (int) event.values[0];
                tvStepCount.setText(stepCount + " Steps");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used for this app
    }

    private void startTracking() {
        isTracking = true;
        btnStartStop.setText("Stop Tracking");
        stepCount = 0;  // Reset the step count when starting
    }

    private void stopTracking() {
        isTracking = false;
        btnStartStop.setText("Start Tracking");
    }
}
