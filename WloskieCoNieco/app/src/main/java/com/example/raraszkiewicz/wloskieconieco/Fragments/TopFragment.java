package com.example.raraszkiewicz.wloskieconieco.Fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raraszkiewicz.wloskieconieco.Activities.PizzaDetailActivity;
import com.example.raraszkiewicz.wloskieconieco.Adapters.CaptionedCardAdapter;
import com.example.raraszkiewicz.wloskieconieco.Data.Pizza;
import com.example.raraszkiewicz.wloskieconieco.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopFragment extends Fragment implements CaptionedCardAdapter.Listener
{

    @BindView(R.id.main_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.main_description)
    TextView textView;

    public TopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     * @return A new instance of fragment TopFragment.
     */
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
        View view =  inflater.inflate(R.layout.fragment_top, container, false);
        ButterKnife.bind(this, view);

        CaptionedCardAdapter adapter = new CaptionedCardAdapter(Pizza.pizzas);
        adapter.setListener(this);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);

        textView.setText("Witamy witamy witamy witamy witamy\n witamy witamy witamy");

        return view;
    }

    @Override
    public void onClick(int position)
    {
        Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
        intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_NUMBER, position);
        startActivity(intent);
    }
}
