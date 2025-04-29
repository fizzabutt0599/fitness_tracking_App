package com.example.fitnesstrackingapp;





import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CalorieTrackerActivity extends AppCompatActivity {

    Spinner spinnerActivity;
    EditText editTime;
    Button btnCalculate;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_tracker);

        spinnerActivity = findViewById(R.id.spinnerActivity);
        editTime = findViewById(R.id.editTime);
        btnCalculate = findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);

        String[] activities = {"Walking", "Running", "Cycling"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, activities);
        spinnerActivity.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCalories();
            }
        });
    }

    private void calculateCalories() {
        String selectedActivity = spinnerActivity.getSelectedItem().toString();
        String timeStr = editTime.getText().toString();

        if (timeStr.isEmpty()) {
            Toast.makeText(this, "Please enter time", Toast.LENGTH_SHORT).show();
            return;
        }

        int time = Integer.parseInt(timeStr);
        double caloriesPerMinute;

        switch (selectedActivity) {
            case "Walking":
                caloriesPerMinute = 4.5;
                break;
            case "Running":
                caloriesPerMinute = 10.0;
                break;
            case "Cycling":
                caloriesPerMinute = 8.5;
                break;
            default:
                caloriesPerMinute = 0;
        }

        double totalCalories = caloriesPerMinute * time;
        textResult.setText("Calories Burned: " + totalCalories);
    }
}


