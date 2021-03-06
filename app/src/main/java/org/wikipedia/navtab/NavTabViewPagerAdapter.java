package org.wikipedia.navtab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NavTabViewPagerAdapter extends FragmentPagerAdapter {
    public NavTabViewPagerAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override public Fragment getItem(int pos) {
        return NavTab.of(pos).newInstance();
    }

    @Override public int getCount() {
        return NavTab.size();
    }
}