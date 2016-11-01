package com.example.raraszkiewicz.drogomierz.Odometer;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;

public class OdometerService extends Service {

    OdometerBinder binder;
    OdometerLocationListener locationListener;

    @Override
    public void onCreate() {

        registerLocationListener();
        super.onCreate();
    }

    private void registerLocationListener() {
        locationListener = new OdometerLocationListener();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //ActivityCompat.requestPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION, 0x1);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
    }

    public double getDistance()
    {
        return locationListener.getDistance()/1000;
    }

    public OdometerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        if(binder == null)
            binder = new OdometerBinder(this);
        return binder;
    }
}
