package com.arasz.trenazer.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arasz.trenazer.Data.DataProvider;
import com.arasz.trenazer.Models.Workout;
import com.arasz.trenazer.R;
import com.arasz.trenazer.Utils.FragmentReplacer;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailsFragment extends Fragment {

    @NonNull
    View fragmentLayout;

    TextView title;
    TextView description;

    public int getWorkoutId() {
        return workoutId;
    }

    private void onWorkoutChanged(int id)
    {
        Workout workout = DataProvider.getWorkouts()[id];
        if(title == null || description == null)
            return;
        title.setText(workout.getName());
        description.setText(workout.getDescription());
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
        onWorkoutChanged(workoutId);
    }

    private int workoutId;

    @Override
    public void onStart() {
        super.onStart();
        fragmentLayout = getView();

        if(fragmentLayout == null)
            throw new NullPointerException(WorkoutDetailsFragment.class.getSimpleName() + "view is null");

        title = (TextView) fragmentLayout.findViewById(R.id.workout_title);
        description = (TextView) fragmentLayout.findViewById(R.id.workout_description);

        onWorkoutChanged(workoutId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState == null)
        {
            // replace fragment only if its parent was created first time
            // android is taking care of restoring previous fragment when device is rotated
            FragmentReplacer fragmentReplacer = FragmentReplacer.createFragmentReplacer(getChildFragmentManager(), R.id.stopwatch_container);
            fragmentReplacer.replace(StopwatchFragment.newInstance());
        }
        else
            workoutId = savedInstanceState.getInt("workoutId");



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_details, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("workoutId", workoutId);
    }
}
