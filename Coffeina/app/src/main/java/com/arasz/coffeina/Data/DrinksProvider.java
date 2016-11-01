package com.arasz.coffeina.Data;

import com.arasz.coffeina.Models.Drink;
import com.arasz.coffeina.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 04.09.2016.
 */
public class DrinksProvider
{
    public static Drink[] getDrinks() {
        return drinks;
    }

    private static Drink[] drinks = {
            new Drink("Latte", "Czarne espresso z gorącym mlekiem i mleczną pianką", R.drawable.latte),
            new Drink("Cappuccino", "Czarne espresso z dużą ilością spienionego mleka", R.drawable.cappuccino),
            new Drink("Espresso", "Czarna kawa ze świeżo mielonych ziaren najwyższej jakości", R.drawable.filter),
    };
}
