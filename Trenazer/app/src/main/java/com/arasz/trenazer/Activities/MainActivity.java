package com.arasz.trenazer.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arasz.trenazer.Fragments.WorkoutDetailsFragment;
import com.arasz.trenazer.Interfaces.WorkoutListListener;
import com.arasz.trenazer.R;
import com.arasz.trenazer.Utils.FragmentReplacer;

public class MainActivity extends AppCompatActivity implements WorkoutListListener{

    FragmentReplacer fragmentReplacer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void replaceFragment(Fragment newFragment) {
        if(fragmentReplacer == null)
            fragmentReplacer = FragmentReplacer.createFragmentReplacer(getFragmentManager(), R.id.fragment_container);
        fragmentReplacer.replace(newFragment);
    }

    @Override
    public void itemClicked(int id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        //phone
        if(fragmentContainer == null)
        {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("workoutId", id);
            startActivity(intent);
        }
        //tablet
        else
        {
            WorkoutDetailsFragment detailsFragment = new WorkoutDetailsFragment();
            detailsFragment.setWorkoutId(id);
            replaceFragment(detailsFragment);
        }

    }
}
