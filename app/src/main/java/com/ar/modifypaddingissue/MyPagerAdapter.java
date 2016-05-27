package com.ar.modifypaddingissue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by antoine on 5/26/16.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private MyFragment.Listener listener;

    public MyPagerAdapter(FragmentManager fm, MyFragment.Listener listener) {
        super(fm);

        this.listener = listener;
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(listener);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
