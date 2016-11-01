package com.example.raraszkiewicz.coffeina.Data;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by r.araszkiewicz on 25.09.2016.
 */

public class CoffeinaDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "coffeina";
    private static final int DB_VERSION = 1;

    public CoffeinaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableQuery());
    }

    public String createTableQuery()
    {
        String query = "CREATE TABLE ";
        Class drinkClass = Drink.class;
        query += drinkClass.getSimpleName() + " (";
        Field[] fields = drinkClass.getDeclaredFields();
        for (Field field : fields)
        {
            if(field.getName().equalsIgnoreCase("id"))
                query += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
            else
            {
                query+= field.getName() +" "+ inferSqlType(Drink.class) + ", ";
            }
        }
        query = query.substring(0, query.length()-2);
        query += " );";
        return query;
    }

    public String inferSqlType(Class clazz)
    {
        String typeName = clazz.getSimpleName();
        if(typeName.equalsIgnoreCase(String.class.getSimpleName()))
            return "TEXT";
        else if(typeName.equalsIgnoreCase(int.class.getSimpleName()))
            return "INTEGER";
        else if(typeName.equalsIgnoreCase(double.class.getSimpleName()))
            return "REAL";
        else if( typeName.equalsIgnoreCase(boolean.class.getSimpleName()))
            return "NUMERIC";
        else
            return "TEXT";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
