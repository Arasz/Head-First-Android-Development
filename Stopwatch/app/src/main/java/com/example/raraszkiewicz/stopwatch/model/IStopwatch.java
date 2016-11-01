package com.example.raraszkiewicz.stopwatch.model;

/**
 * Created by r.araszkiewicz on 01.09.2016.
 */
public interface IStopwatch
{
    void Start();

    void Stop();

    void Reset();

    String getFormatedTime();
}
