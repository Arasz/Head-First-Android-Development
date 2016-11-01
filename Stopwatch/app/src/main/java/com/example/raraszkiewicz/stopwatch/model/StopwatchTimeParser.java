package com.example.raraszkiewicz.stopwatch.model;

/**
 * Created by r.araszkiewicz on 01.09.2016.
 */
public class StopwatchTimeParser implements ITimeParser {

    private long getSeconds(long milliseconds)
    {
        return milliseconds/1000;
    }

    private long getMinutes(long milliseconds)
    {
        return milliseconds/(60*1000);
    }

    private long getHours(long milliseconds)
    {
        return milliseconds/(60*1000*60);
    }

    @Override
    public String Parse(long time) {
        long hours = getHours(time);
        long minutes = getMinutes(time)-(hours*60);
        long seconds = getSeconds(time)-(minutes*60)-(hours*3600);

        return hours  + ":" +takeLast(("0"+minutes),2) + ":" + takeLast(("0"+seconds),2);
    }

    private String takeLast(String string, int length)
    {
        int startIndex = string.length() - length;
        if(startIndex < 0)
            throw new IllegalArgumentException("Given length greater than string length");
        return string.substring(startIndex);
    }
}
