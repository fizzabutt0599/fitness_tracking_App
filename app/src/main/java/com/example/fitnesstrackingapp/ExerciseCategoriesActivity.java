

package com.example.fitnesstrackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ExerciseCategoriesActivity extends AppCompatActivity {

    ListView categoryListView;
    ArrayList<String> exerciseCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_categories);

        categoryListView = findViewById(R.id.categoryListView);
        exerciseCategories = new ArrayList<>();

        // Add exercise categories
        exerciseCategories.add("Full Body");
        exerciseCategories.add("Upper Body");
        exerciseCategories.add("Lower Body");
        exerciseCategories.add("Cardio");
        exerciseCategories.add("Core/Abs");
        exerciseCategories.add("Stretching");
        exerciseCategories.add("Warm-Up");

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                exerciseCategories
        );

        categoryListView.setAdapter(adapter);

        // Handle item clicks to open detail activity
        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
            String category = exerciseCategories.get(position);

            Intent intent = new Intent(ExerciseCategoriesActivity.this, ExerciseDetailActivity.class);
            intent.putExtra("category", category);
            startActivity(intent);
        });
    }
}
