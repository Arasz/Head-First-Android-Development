package com.arasz.coffeina.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arasz.coffeina.R;

public class MainActivity extends AppCompatActivity {

    private ListView categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories = (ListView) findViewById(R.id.categoriesList);
        categories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemView, int position, long id) {
                String[] categories = getResources().getStringArray(R.array.categories);
                if(categories[position] == categories[0])
                {
                    Intent drinksIntent = new Intent(MainActivity.this, DrinkCategoryActivity.class);
                    startActivity(drinksIntent);
                }
            }
        });
    }
}
