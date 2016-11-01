package com.example.raraszkiewicz.wloskieconieco.Data;

import com.example.raraszkiewicz.wloskieconieco.R;

/**
 * Created by Rafal on 01.11.2016.
 * Pizza entity representation
 */

public class Pizza implements NamedImage {

    private String name;

    private int imageId;

    public Pizza(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public static final Pizza[] pizzas = {
            new Pizza("Diavolo", R.drawable.diavolo),
            new Pizza("Funghi", R.drawable.funghi)
    };

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

}
