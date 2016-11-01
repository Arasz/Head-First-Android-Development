package com.arasz.coffeina.Activities.DrinkArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.arasz.coffeina.Models.Drink;
import com.arasz.coffeina.R;

import java.util.Arrays;

/**
 * Created by Rafal on 04.09.2016.
 */
public class DrinksAdapter extends ArrayAdapter<Drink> {
    public DrinksAdapter(Context context, Drink[] objects) {
        super(context, 0, Arrays.asList(objects));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Drink currentItem = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.simple_drink_item, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);

        nameTextView.setText(currentItem.getName());

        return convertView;
    }
}
