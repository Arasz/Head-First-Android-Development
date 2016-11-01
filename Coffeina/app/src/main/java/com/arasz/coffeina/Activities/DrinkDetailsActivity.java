package com.arasz.coffeina.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.arasz.coffeina.Data.DrinksProvider;
import com.arasz.coffeina.Models.Drink;
import com.arasz.coffeina.R;

public class DrinkDetailsActivity extends AppCompatActivity {

    TextView name;
    ImageView picture;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_details);
        InitializeViewVariables();

        Intent passedIntent = getIntent();
        int drinkIndex = passedIntent.getIntExtra(Drink.class.getName(), -1);

        BindModel(DrinksProvider.getDrinks()[drinkIndex]);
    }

    private void BindModel(Drink model)
    {
        name.setText(model.getName());
        picture.setImageResource(model.getImageId());
        picture.setContentDescription(model.getName());
        description.setText(model.getDescription());
    }

    private void InitializeViewVariables() {
        name = (TextView) findViewById(R.id.name);
        picture = (ImageView) findViewById(R.id.picture);
        description = (TextView) findViewById(R.id.description);
    }

}
