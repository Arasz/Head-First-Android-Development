package com.example.raraszkiewicz.wloskieconieco.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raraszkiewicz.wloskieconieco.Adapters.CaptionedCardAdapter;
import com.example.raraszkiewicz.wloskieconieco.Data.Pizza;
import com.example.raraszkiewicz.wloskieconieco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaMaterialFragment extends Fragment
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

		pizzaRecycler.setAdapter(new CaptionedCardAdapter(Pizza.pizzas));
		pizzaRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

		return pizzaRecycler;
	}

}
