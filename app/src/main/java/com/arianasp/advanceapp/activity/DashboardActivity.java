package com.arianasp.advanceapp.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arianasp.advanceapp.R;
import com.arianasp.advanceapp.activity.BaseActivity;

public class DashboardActivity extends BaseActivity {

    RecyclerView recyclerViewIncome;
    RecyclerView recyclerViewExpenses;
    RecyclerView.Adapter rvAdapterIncome, rvAdapterExpenses;
    RecyclerView.LayoutManager rvLmIncome, rvLmExpenses;
    Cursor cIncome, cExpenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
    }



}
