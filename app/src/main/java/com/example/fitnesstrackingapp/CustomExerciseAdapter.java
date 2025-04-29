package com.example.fitnesstrackingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class CustomExerciseAdapter extends ArrayAdapter<String> {

    private final Map<String, String> repsMap;
    private final Map<String, String> durationMap;

    public CustomExerciseAdapter(Context context, ArrayList<String> exercises,
                                 Map<String, String> repsMap, Map<String, String> durationMap) {
        super(context, 0, exercises);
        this.repsMap = repsMap;
        this.durationMap = durationMap;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String exercise = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_exercise, parent, false);
        }

        TextView exerciseNameTextView = convertView.findViewById(R.id.exerciseNameTextView);
        TextView exerciseSubTextView = convertView.findViewById(R.id.exerciseSubTextView);

        exerciseNameTextView.setText(exercise);
        String reps = repsMap.getOrDefault(exercise, "15 reps");
        String duration = durationMap.getOrDefault(exercise, "30 seconds");
        exerciseSubTextView.setText(reps + " | " + duration);

        return convertView;
    }
}
