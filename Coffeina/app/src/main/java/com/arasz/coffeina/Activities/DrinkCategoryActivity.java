package com.arasz.coffeina.Activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.arasz.coffeina.Activities.DrinkArrayAdapter.DrinksAdapter;
import com.arasz.coffeina.Data.DrinksProvider;
import com.arasz.coffeina.Models.Drink;

public class DrinkCategoryActivity extends ListActivity {

    private ArrayAdapter<Drink> drinksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drink_category);

        drinksAdapter = new DrinksAdapter(this, DrinksProvider.getDrinks());
        getListView().setAdapter(drinksAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, DrinkDetailsActivity.class);
        intent.putExtra(Drink.class.getName(), position);
        startActivity(intent);
    }
}
