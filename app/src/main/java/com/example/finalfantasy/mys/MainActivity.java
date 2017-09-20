package com.example.finalfantasy.mys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.finalfantasy.mys.adapters.TabPagerFragmentAdapter;

public class MainActivity extends AppCompatActivity {


    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initTab();
    }

    private void initTab() {
        mPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabL = (TabLayout) findViewById(R.id.taB);
        TabPagerFragmentAdapter adapter = new TabPagerFragmentAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);
        tabL.setupWithViewPager(mPager);
    }
}
