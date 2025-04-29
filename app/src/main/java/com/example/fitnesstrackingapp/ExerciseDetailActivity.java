package com.example.fitnesstrackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExerciseDetailActivity extends AppCompatActivity {

    private TextView categoryTitleTextView;
    private ListView exercisesListView;

    private final Map<String, ArrayList<String>> exercisesMap = new HashMap<>();
    private final Map<String, String> repsMap = new HashMap<>();
    private final Map<String, String> durationMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        initializeViews();
        initializeData();

        String category = getIntent().getStringExtra("category");
        if (category != null) {
            categoryTitleTextView.setText(category);
            setupExerciseList(category);
        }
    }

    private void initializeViews() {
        categoryTitleTextView = findViewById(R.id.categoryTitle);
        exercisesListView = findViewById(R.id.exercisesListView);
    }

    private void initializeData() {
        exercisesMap.put("Full Body", new ArrayList<String>() {{
            add("Jumping Jacks");
            add("Burpees");
            add("Mountain Climbers");
            add("Squat Jumps");
        }});

        exercisesMap.put("Upper Body", new ArrayList<String>() {{
            add("Push-ups");
            add("Shoulder Taps");
            add("Arm Circles");
            add("Tricep Dips");
        }});

        exercisesMap.put("Lower Body", new ArrayList<String>() {{
            add("Lunges");
            add("Wall Sit");
            add("Calf Raises");
            add("Glute Bridges");
        }});

        exercisesMap.put("Cardio", new ArrayList<String>() {{
            add("High Knees");
            add("Jump Rope");
            add("Butt Kicks");
            add("Skaters");
        }});

        exercisesMap.put("Core/Abs", new ArrayList<String>() {{
            add("Plank");
            add("Sit-ups");
            add("Leg Raises");
            add("Russian Twists");
        }});

        exercisesMap.put("Stretching", new ArrayList<String>() {{
            add("Hamstring Stretch");
            add("Quad Stretch");
            add("Shoulder Stretch");
            add("Cat-Cow Stretch");
        }});

        exercisesMap.put("Warm-Up", new ArrayList<String>() {{
            add("Arm Swings");
            add("Leg Swings");
            add("Neck Rolls");
            add("Hip Circles");
        }});

        // Map Reps and Duration
        addExerciseDetails("Jumping Jacks", "30 reps", "45 seconds");
        addExerciseDetails("Burpees", "20 reps", "40 seconds");
        addExerciseDetails("Mountain Climbers", "25 reps", "50 seconds");
        addExerciseDetails("Squat Jumps", "15 reps", "30 seconds");

        addExerciseDetails("Push-ups", "20 reps", "40 seconds");
        addExerciseDetails("Shoulder Taps", "30 taps", "45 seconds");
        addExerciseDetails("Arm Circles", "40 circles", "60 seconds");
        addExerciseDetails("Tricep Dips", "15 reps", "30 seconds");

        addExerciseDetails("Lunges", "20 reps", "35 seconds");
        addExerciseDetails("Wall Sit", "Hold", "45 seconds");
        addExerciseDetails("Calf Raises", "25 reps", "40 seconds");
        addExerciseDetails("Glute Bridges", "20 reps", "40 seconds");

        addExerciseDetails("High Knees", "Run in place", "45 seconds");
        addExerciseDetails("Jump Rope", "100 jumps", "1 minute");
        addExerciseDetails("Butt Kicks", "Run in place", "45 seconds");
        addExerciseDetails("Skaters", "20 reps", "40 seconds");

        addExerciseDetails("Plank", "Hold", "1 minute");
        addExerciseDetails("Sit-ups", "20 reps", "45 seconds");
        addExerciseDetails("Leg Raises", "15 reps", "40 seconds");
        addExerciseDetails("Russian Twists", "30 twists", "50 seconds");

        addExerciseDetails("Hamstring Stretch", "Hold", "30 seconds");
        addExerciseDetails("Quad Stretch", "Hold", "30 seconds");
        addExerciseDetails("Shoulder Stretch", "Hold", "30 seconds");
        addExerciseDetails("Cat-Cow Stretch", "10 rounds", "1 minute");

        addExerciseDetails("Arm Swings", "20 swings", "30 seconds");
        addExerciseDetails("Leg Swings", "20 swings", "30 seconds");
        addExerciseDetails("Neck Rolls", "10 rolls each side", "30 seconds");
        addExerciseDetails("Hip Circles", "20 circles", "30 seconds");
    }

    private void addExerciseDetails(String exercise, String reps, String duration) {
        repsMap.put(exercise, reps);
        durationMap.put(exercise, duration);
    }

    private void setupExerciseList(String category) {
        ArrayList<String> exercises = exercisesMap.getOrDefault(category, new ArrayList<>());

        assert exercises != null;
        CustomExerciseAdapter adapter = new CustomExerciseAdapter(
                this,
                exercises,
                repsMap,
                durationMap
        );
        exercisesListView.setAdapter(adapter);

        exercisesListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedExercise = exercises.get(position);
            String reps = repsMap.getOrDefault(selectedExercise, "15 reps");
            String duration = durationMap.getOrDefault(selectedExercise, "30 seconds");

            Intent intent = new Intent(ExerciseDetailActivity.this, ExerciseInfoActivity.class);
            intent.putExtra("exerciseName", selectedExercise);
            intent.putExtra("reps", reps);
            intent.putExtra("duration", duration);
            startActivity(intent);
        });
    }
}
