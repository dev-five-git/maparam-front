package com.example.myapplication.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainPageViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentManager fm = null;
    private Context context = null;
    public MainPageViewPagerAdapter(@NonNull FragmentManager fm, Context context,ArrayList<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.context = context;
        this.fragments = fragments;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
