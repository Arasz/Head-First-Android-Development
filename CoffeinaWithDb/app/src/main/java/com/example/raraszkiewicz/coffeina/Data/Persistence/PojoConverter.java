package com.example.raraszkiewicz.coffeina.Data.Persistence;

import android.content.ContentValues;

/**
 * Created by r.araszkiewicz on 26.09.2016.
 * Converts POJO object to object that can be passed to sqlite database
 */

public interface PojoConverter {
    ContentValues convert(Object pojo) throws IllegalAccessException;
}
