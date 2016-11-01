package com.example.raraszkiewicz.drogomierz;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.raraszkiewicz.drogomierz.Odometer.OdometerBinder;
import com.example.raraszkiewicz.drogomierz.Odometer.OdometerService;

public class MainActivity extends AppCompatActivity {

    private boolean bound;
    private OdometerService odometerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        watchDistance();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(bound)
        {
            unbindService(serviceConnection);
            bound = false;
        }
    }

    private void watchDistance()
    {
        final TextView textView = (TextView) findViewById(R.id.distance);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                double distance = 0.0;
                if(odometerService != null)
                    distance = odometerService.getDistance();

                String distanceString = String.format("%1$,.2f km", distance);
                textView.setText(distanceString);
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, OdometerService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            OdometerBinder binder = (OdometerBinder) service;
            odometerService = binder.getOdometer();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }
    };
}
