package com.example.learnfragment.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.learnfragment.fragment.FragmentFood;
import com.example.learnfragment.fragment.FragmentMovie;
import com.example.learnfragment.fragment.FragmentTravel;

public class AdapterViewpager extends FragmentPagerAdapter {
    private int numPage = 3;
    public AdapterViewpager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        numPage = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentFood();
            case 1:
                return new FragmentMovie();
            case 2:
                return new FragmentTravel();
            default:
                return new FragmentFood();
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Food";
            case 1:
                return "Movie";
            case 2:
                return "Travel";
            default:
                return "Food";
        }
    }
}
