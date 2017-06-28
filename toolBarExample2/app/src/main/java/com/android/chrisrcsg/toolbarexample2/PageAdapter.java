package com.android.chrisrcsg.toolbarexample2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by ChrisRCSG on 27/06/17.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    private int numeroDeTabs;

    public PageAdapter(FragmentManager fm, int numeroDeTabs){
        super(fm);
        this.numeroDeTabs = numeroDeTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numeroDeTabs;
    }
}
