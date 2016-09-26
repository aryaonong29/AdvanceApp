package com.arianasp.advanceapp.modelExpenses;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arianasp.advanceapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariana on 9/24/2016.
 */

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesHolder> {
    private Fragment mFragment;
    private List<ExpensesModel> expensesStuff;



    public ExpensesAdapter(List<ExpensesModel> expensesStuff,Fragment fragment){
        this.expensesStuff = new ArrayList<ExpensesModel>();
        this.expensesStuff.addAll(expensesStuff);
        this.mFragment = fragment;
    }


    @Override
    public ExpensesHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.fragment_expenses, viewGroup, false);
        return new ExpensesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpensesHolder expHolder, int i) {
        Expenses exp = expensesStuff.get(i);
        expHolder.stuff.setText(exp.getStuf());
        expHolder.price.setText(exp.getPrice());
        expHolder.v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mFragment.onItemClicked(position);
            }
        });
        expHolder.v.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                mFragment.onItemLongClicked(position);
                return true;
            }
        });

    }


    @Override
    public int getItemCount() {
        return expensesStuff.size();
    }
}