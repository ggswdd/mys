package com.example.finalfantasy.mys.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.finalfantasy.mys.fragmentClases.Citys;
import com.example.finalfantasy.mys.fragmentClases.Favorits;


public class TabPagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] mTabs;

    public TabPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        mTabs = new String[]{
                "Search by city", "Favorits"
        };
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Citys.getInstace();
            case 1:
                return Favorits.getInstace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }
}
