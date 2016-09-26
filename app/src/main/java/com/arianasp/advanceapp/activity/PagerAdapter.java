package com.arianasp.advanceapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.arianasp.advanceapp.fragment.CardExpensesFragment;
import com.arianasp.advanceapp.fragment.CardIncomeFragment;

/**
 * Created by Ariana on 9/26/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CardExpensesFragment tab1 = new CardExpensesFragment();
                return tab1;
            case 1:
                CardIncomeFragment tab2 = new CardIncomeFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

