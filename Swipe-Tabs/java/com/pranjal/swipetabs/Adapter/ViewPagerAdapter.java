package com.pranjal.swipetabs.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.pranjal.swipetabs.Fragment.TabsFragment;

/**
 * Created by royalpranjal on 6/26/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    // implementation of view pager adapter that uses a fragment to manage each page

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new TabsFragment();
    }

    @Override
    public int getCount() {
        return 3;
        // number of tabs is 3
    }
}
