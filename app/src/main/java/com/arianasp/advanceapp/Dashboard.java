package com.arianasp.advanceapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Dashboard extends BaseActivity {

    String stuff,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        initiView();

        //recylerview income overview title
        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView1.setHasFixedSize(true);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        llm1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(llm1);
        recyclerView1.setAdapter(new TitleAdapter(generateTitle()));


        //recylerview expenses overview stuff and price
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(llm2);
        recyclerView2.setAdapter(new ExpensesAdapter(generateStuff()));
    }

    private ArrayList<TitleCard> generateTitle(){
        ArrayList<TitleCard> title = new ArrayList<>();
        for (int i = 0;i <= title.size();i++){
            title.add(new TitleCard("Overview Income"));
            title.add(new TitleCard("Overview Expenses"));
        }
        return title;
    }

    private ArrayList<Expenses> generateStuff(){
        ArrayList<Expenses> expStuff = new ArrayList<>();
        for (int i = 0;i <= expStuff.size();i++){
            
        }
        return expStuff;
    }





}
