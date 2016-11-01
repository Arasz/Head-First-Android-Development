package com.example.raraszkiewicz.wloskieconieco.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.raraszkiewicz.wloskieconieco.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PizzaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PizzaFragment extends ListFragment {

    public PizzaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PizzaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PizzaFragment newInstance() {
        PizzaFragment fragment = new PizzaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.pizzas));
        setListAdapter(arrayAdapter);
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
