package com.example.fitnesstrackingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExerciseAdapter extends ArrayAdapter<String> {

    private HashMap<String, String> repsMap;
    private HashMap<String, String> durationMap;

    public ExerciseAdapter(Context context, ArrayList<String> exercises, HashMap<String, String> repsMap, HashMap<String, String> durationMap) {
        super(context, 0, exercises);
        this.repsMap = repsMap;
        this.durationMap = durationMap;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String exercise = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_list_item, parent, false);
        }

        TextView exerciseNameTextView = convertView.findViewById(R.id.exerciseNameTextView);
        TextView repsAndDurationTextView = convertView.findViewById(R.id.repsAndDurationTextView);

        exerciseNameTextView.setText(exercise);

        String reps = repsMap.getOrDefault(exercise, "15 reps");
        String duration = durationMap.getOrDefault(exercise, "30 seconds");

        repsAndDurationTextView.setText(reps + " | " + duration);

        return convertView;
    }
}
