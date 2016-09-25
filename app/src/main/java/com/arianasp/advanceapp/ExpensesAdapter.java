package com.arianasp.advanceapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariana on 9/24/2016.
 */

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesHolder> {

    private List<Expenses> expensesStuff;

    public ExpensesAdapter(List<Expenses> expensesStuff){
        this.expensesStuff = new ArrayList<Expenses>();
        this.expensesStuff.addAll(expensesStuff);
    }


    @Override
    public ExpensesHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);
        return new ExpensesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpensesHolder expHolder, int i) {
        Expenses exp = expensesStuff.get(i);
        expHolder.stuff.setText(exp.getStuf());
        expHolder.price.setText(exp.getPrice());

    }


    @Override
    public int getItemCount() {
        return expensesStuff.size();
    }
}