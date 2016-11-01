package com.example.raraszkiewicz.coffeina;

import com.example.raraszkiewicz.coffeina.Activities.MainActivity;
import com.example.raraszkiewicz.coffeina.Data.CoffeinaDatabaseHelper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by r.araszkiewicz on 26.09.2016.
 */

public class CoffeinaDatabaseHelperTest {

    private CoffeinaDatabaseHelper helper;

    @Before
    public void setUp()
    {
        helper = new CoffeinaDatabaseHelper(new MainActivity());
    }

    @Test
    public void createTableQuery_isCorrect()
    {
        String query = helper.createTableQuery();
        String expected = "CREATE TABLE Drink ("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "name TEXT, "+
                "description TEXT, "+
                "imageId TEXT );";

        Assert.assertEquals("Create table query",expected, query);
    }

    @Test
    public void inferSqlType_givenObjectOfType_isCorrect()
    {

    }
}
