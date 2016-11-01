package com.arasz.trenazer.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.arasz.trenazer.Data.DataProvider;
import com.arasz.trenazer.Interfaces.WorkoutListListener;
import com.arasz.trenazer.Models.Workout;
import com.arasz.trenazer.R;

public class WorkoutListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private View workoutListView;
    private ListView listView;
    private ListAdapter workoutListAdapter;
    private WorkoutListListener workoutListListener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof WorkoutListListener)
            workoutListListener = (WorkoutListListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_list, container, false);
    }

    private void configureListView() {
        workoutListAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, DataProvider.getWorkouts());
        listView = (ListView) workoutListView.findViewById(R.id.workouts_list_view);
        listView.setAdapter(workoutListAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        workoutListView = getView();
        configureListView();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if(workoutListListener != null)
            workoutListListener.itemClicked(position);
    }
}
