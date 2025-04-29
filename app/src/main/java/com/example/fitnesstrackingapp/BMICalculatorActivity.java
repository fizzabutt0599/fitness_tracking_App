package com.example.fitnesstrackingapp;



import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity {

    EditText editWeight, editHeight;
    Button btnCalculateBMI;
    TextView textBMIResult, textBMICategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        textBMIResult = findViewById(R.id.textBMIResult);
        textBMICategory = findViewById(R.id.textBMICategory);

        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editWeight.getText().toString();
        String heightStr = editHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double heightCm = Double.parseDouble(heightStr);
        double heightM = heightCm / 100;

        double bmi = weight / (heightM * heightM);
        textBMIResult.setText(String.format("Your BMI: %.2f", bmi));

        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 24.9) {
            category = "Normal weight";
        } else if (bmi < 29.9) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        textBMICategory.setText("Category: " + category);
    }
}

