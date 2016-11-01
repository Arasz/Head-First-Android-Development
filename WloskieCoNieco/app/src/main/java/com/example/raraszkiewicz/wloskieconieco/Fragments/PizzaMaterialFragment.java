package com.example.raraszkiewicz.wloskieconieco.Fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.raraszkiewicz.wloskieconieco.Activities.PizzaDetailActivity;
import com.example.raraszkiewicz.wloskieconieco.Adapters.CaptionedCardAdapter;
import com.example.raraszkiewicz.wloskieconieco.Data.Pizza;
import com.example.raraszkiewicz.wloskieconieco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaMaterialFragment extends Fragment implements CaptionedCardAdapter.Listener
{


	public PizzaMaterialFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		RecyclerView pizzaRecycler = (RecyclerView) inflater
				.inflate(R.layout.fragment_pizza_material, container, false);

		CaptionedCardAdapter adapter = new CaptionedCardAdapter(Pizza.pizzas);
		adapter.setListener(this);

		pizzaRecycler.setAdapter(adapter);
		pizzaRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

		return pizzaRecycler;
	}

	@Override
	public void onClick(int position)
	{
		Intent detailsIntent = new Intent(getActivity(), PizzaDetailActivity.class);
		detailsIntent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_NUMBER, position);
		startActivity(detailsIntent);
	}
}
