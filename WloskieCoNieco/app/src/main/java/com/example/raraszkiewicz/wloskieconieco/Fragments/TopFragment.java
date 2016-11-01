package com.example.raraszkiewicz.wloskieconieco.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raraszkiewicz.wloskieconieco.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopFragment extends Fragment {
    public TopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     * @return A new instance of fragment TopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopFragment newInstance() {
        TopFragment fragment = new TopFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

}
