package com.arasz.trenazer.Data;

import com.arasz.trenazer.Models.Workout;

/**
 * Created by Rafal on 06.09.2016.
 */
public class DataProvider {

    private static Workout[] workouts =
            {
                    new Workout("Rozciganie", "266blsrgvbdbrb\n10sgdrgrdg\n2wfrgg"),
                    new Workout("Ogolna agonia", "42blsrgvbdbrb\n10sgdrgrdg\n2wfrgg"),
                    new Workout("Tylko dla mieczakow", "23blsrgvbdbrb\n10sgdrgrdg\n2wfrgg"),
                    new Workout("Sila i dystans", "2blsrgvrdybdbrb\n10sgdrgrdg\n2wfrgg")
            };
    public static Workout[] getWorkouts()
    {
        return workouts;
    }
}
