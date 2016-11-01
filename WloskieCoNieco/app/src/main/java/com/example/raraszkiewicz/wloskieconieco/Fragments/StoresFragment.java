package com.example.raraszkiewicz.wloskieconieco.Fragments;


import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.raraszkiewicz.wloskieconieco.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoresFragment extends ListFragment {

    public StoresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoresFragment newInstance() {
        StoresFragment fragment = new StoresFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.cities));
        setListAdapter(arrayAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
