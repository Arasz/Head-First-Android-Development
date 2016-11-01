package com.example.raraszkiewicz.coffeina.Data.Persistence;

import android.content.ContentValues;

import java.lang.reflect.Field;

/**
 * Created by r.araszkiewicz on 26.09.2016.
 */

public class SimplePojoConverter implements PojoConverter {

    @Override
    public ContentValues convert(Object pojo) throws IllegalAccessException {
        Class clazz = pojo.getClass();
        Field[] fields = clazz.getFields();
        if(!containsId(fields))
            throw new IllegalArgumentException("Object must have id field!");

        return getValues(fields, pojo);
    }


    private ContentValues getValues( Field[] fields, Object pojo) throws IllegalAccessException {
        ContentValues values = new ContentValues();
        for (Field field : fields)
        {
            if(field.getName().equalsIgnoreCase("id"))
                values.put("_"+field.getName().toLowerCase(), field.getInt(pojo));

            Object primitive = field.get(pojo);
            if(primitive instanceof Integer)
                values.put(field.getName(), (int)primitive);
            else if(primitive instanceof String)
                values.put(field.getName(), (String) primitive);
            else if(primitive instanceof Boolean)
                values.put(field.getName(), (Boolean) primitive);
            else
            values.put(field.getName(), String.valueOf(primitive));
        }
        return values;
    }


    private boolean containsId(Field[] fields)
    {
        for (Field field : fields)
        {
            if(field.getName().equalsIgnoreCase("id"))
                return true;
        }
        return false;
    }
}
