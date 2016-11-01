package com.example.raraszkiewicz.wloskieconieco.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.raraszkiewicz.wloskieconieco.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PastaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PastaFragment extends Fragment {

    @BindView(R.id.pasta_list)
    ListView pastaList;

    public PastaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PastaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PastaFragment newInstance() {
        PastaFragment fragment = new PastaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_pasta, container, false);
        ButterKnife.bind(this, view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pastas));
        pastaList.setAdapter(arrayAdapter);

        return view;
    }

}
