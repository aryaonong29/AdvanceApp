package com.arianasp.advanceapp.modelExpenses;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.arianasp.advanceapp.R;

/**
 * Created by mycomputer on 26/09/16.
 */

public class ExpensesHolder extends RecyclerView.ViewHolder {

    protected EditText stuff, price;
    protected CardView card;
    public View v;

    public ExpensesHolder(View v) {
        super(v);
        this.v = v;
        stuff = (EditText) v.findViewById(R.id.stuff);
        price = (EditText) v.findViewById(R.id.price);
        card = (CardView) v;
    }
}
