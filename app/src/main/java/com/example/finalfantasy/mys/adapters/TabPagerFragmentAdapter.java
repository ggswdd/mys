package com.example.finalfantasy.mys.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.finalfantasy.mys.fragmentClases.CityFragment;
import com.example.finalfantasy.mys.fragmentClases.FragmentFavorites;


public class TabPagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] mTabs;

    public TabPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        mTabs = new String[]{
                "Search by city", "Favorites"
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
                return CityFragment.getInstace();
            case 1:
                return FragmentFavorites.getInstace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }
}
