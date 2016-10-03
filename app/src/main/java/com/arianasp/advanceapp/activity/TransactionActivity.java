package com.arianasp.advanceapp.activity;

import android.os.Bundle;

import com.arianasp.advanceapp.R;


public class TransactionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout); //inisialisasi tab layout
//        tabLayout.addTab(tabLayout.newTab().setText(("New Expense").toUpperCase()));//inisialisasi tab layout utk tampilan tab income
//        tabLayout.addTab(tabLayout.newTab().setText(("New Income").toUpperCase()));//inisialisasi tab layout utk tampilan tab expense
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);//Gravity used to fill the TabLayout as much as possible.


//        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        final PagerAdapter adapter = new PagerAdapter (getSupportFragmentManager(), tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);

//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//

//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }
}
