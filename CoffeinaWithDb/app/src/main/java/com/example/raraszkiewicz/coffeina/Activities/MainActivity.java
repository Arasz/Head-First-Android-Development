package com.example.raraszkiewicz.coffeina.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.raraszkiewicz.coffeina.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    @BindView(R.id.categories_list)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position != 0)
            return;
        Intent drinksIntent = new Intent(this, DrinkCategoryActivity.class);
        startActivity(drinksIntent);
    }
}
