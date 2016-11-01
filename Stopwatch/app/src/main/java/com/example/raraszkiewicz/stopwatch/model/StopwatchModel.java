package com.example.raraszkiewicz.stopwatch.model;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by r.araszkiewicz on 01.09.2016.
 */
public class StopwatchModel implements IStopwatch
{

    private  Thread timerThread;
    private long startTime;
    private long elapsedTime;
    private AtomicBoolean started;
    private ITimeParser timeFormatter;

    public StopwatchModel(ITimeParser timeFormatter) {

        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true)
                    {
                        if(started.get())
                            calculateElapsed();
                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e)
                {

                }
            }
        });
        timerThread.run();
        this.timeFormatter = timeFormatter;
    }

    @Override
    public void Start() {
        started.set(true);
        startTime = System.currentTimeMillis();
    }

    @Override
    public void Stop() {
        started.set(false);
    }

    @Override
    public void Reset() {
        Stop();
        elapsedTime = 0;
    }


    private void calculateElapsed()
    {
        elapsedTime = System.currentTimeMillis() - startTime;
    }

    @Override
    public String getFormatedTime() {
        return timeFormatter.Parse(elapsedTime);
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
