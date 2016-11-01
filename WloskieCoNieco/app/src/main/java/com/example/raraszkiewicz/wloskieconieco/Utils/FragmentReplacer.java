package com.example.raraszkiewicz.wloskieconieco.Utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 *
 * Created by r.araszkiewicz on 24.09.2016.
 */
public class FragmentReplacer
{
    private FragmentManager fragmentManager;
    private int containerId;

    public FragmentReplacer(FragmentManager fragmentManager, int containerId) {
        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
    }

    /**
     * Replaces old fragment with new
     * @param newFragment
     */
    public void replace(Fragment newFragment)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, newFragment, "visible_fragment");
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
}
