package com.example.raraszkiewicz.coffeina.Data;

/**
 * Created by r.araszkiewicz on 25.09.2016.
 */

public class Drink
{
    public int getId() {
        return id;
    }

    int id;
    String name;
    String description;
    int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
