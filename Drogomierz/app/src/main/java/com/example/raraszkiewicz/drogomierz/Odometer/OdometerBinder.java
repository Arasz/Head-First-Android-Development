package com.example.raraszkiewicz.drogomierz.Odometer;

import android.os.Binder;

/**
 * Created by r.araszkiewicz on 30.09.2016.
 */

public class OdometerBinder extends Binder {

    OdometerService odometerService;

    public OdometerBinder(OdometerService odometerService) {
        this.odometerService = odometerService;
    }

    public OdometerService getOdometer()
    {
        return odometerService;
    }
}
