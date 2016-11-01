package com.example.raraszkiewicz.drogomierz.Odometer;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by r.araszkiewicz on 30.09.2016.
 */

class OdometerLocationListener implements LocationListener {

    Location lastLocation;

    private double distance;

    @Override
    public void onLocationChanged(Location location) {
        if(lastLocation != null)
            distance =+ lastLocation.distanceTo(location);

        lastLocation = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public double getDistance() {
        return distance;
    }
}
