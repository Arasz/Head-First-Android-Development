package com.example.raraszkiewicz.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.raraszkiewicz.stopwatch.model.IStopwatch;
import com.example.raraszkiewicz.stopwatch.model.StopwatchModel;
import com.example.raraszkiewicz.stopwatch.model.StopwatchTimeParser;

public class StopwatchActivity extends AppCompatActivity {

    IStopwatch stopwatch;
    TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        timeView = (TextView) findViewById(R.id.timeView);
        stopwatch = new StopwatchModel(new StopwatchTimeParser());
    }

    protected void onStartClicked(View view)
    {
        stopwatch.Start();
    }

    protected void onStopClicked(View view)
    {
        stopwatch.Stop();
        timeView.setText(stopwatch.getFormatedTime());
    }
    protected void onResetClicked(View view)
    {
        stopwatch.Reset();
        timeView.setText(stopwatch.getFormatedTime());
    }
}
