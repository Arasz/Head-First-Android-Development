package com.arasz.trenazer.Models;

/**
 * Created by Rafal on 06.09.2016.
 */
public class Workout
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    String description;

    @Override
    public String toString() {
        return name;
    }
}
