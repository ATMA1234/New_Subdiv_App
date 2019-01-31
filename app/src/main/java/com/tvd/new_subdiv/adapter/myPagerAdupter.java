package com.tvd.new_subdiv.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tvd.new_subdiv.R;
import com.tvd.new_subdiv.fragment.Billing_Fragment;
import com.tvd.new_subdiv.fragment.Reports_Fragment;
import com.tvd.new_subdiv.fragment.Settings_Fragment;

public class myPagerAdupter extends FragmentStatePagerAdapter {
    public String[] getTabs() {
        return tabs;
    }

    private final String[] tabs;
    private Context c;

    public myPagerAdupter(FragmentManager fm, Context c) {
        super(fm);
        this.c = c;
        tabs = c.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        android.support.v4.app.Fragment fragment = new android.support.v4.app.Fragment();
        if (position == 0) {
            fragment = new Billing_Fragment();
        } else if (position == 1) {
            fragment = new Reports_Fragment();
        } else if (position == 2) {
            fragment = new Settings_Fragment();
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return 3;
    }

}