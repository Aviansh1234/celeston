package com.example.electricflightpromotionalapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public void AddFragment(Fragment fragment){
        fragmentList.add(fragment);
    }
}
