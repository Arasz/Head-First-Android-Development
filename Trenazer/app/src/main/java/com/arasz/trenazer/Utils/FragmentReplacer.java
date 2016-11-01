package com.arasz.trenazer.Utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by Rafal on 21.09.2016.
 */

public class FragmentReplacer
{
    private final FragmentManager fragmentManager;
    private final int containerId;

    private FragmentReplacer(FragmentManager fragmentManager, int containerId) {

        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
    }

    public static FragmentReplacer createFragmentReplacer(FragmentManager fragmentManager, int containerId) {
        return new FragmentReplacer(fragmentManager, containerId);
    }

    public void replace(Fragment newFragment)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, newFragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
}
