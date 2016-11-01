package com.arasz.trenazer.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arasz.trenazer.Fragments.WorkoutDetailsFragment;
import com.arasz.trenazer.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        WorkoutDetailsFragment detailsFragment = (WorkoutDetailsFragment) getFragmentManager().findFragmentById(R.id.details_fragment);

        int workoutId = intent.getExtras().getInt("workoutId");
        detailsFragment.setWorkoutId(workoutId);
    }
}
