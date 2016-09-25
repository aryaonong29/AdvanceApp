package com.arianasp.advanceapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Ariana on 9/24/2016.
 */

public class ExpensesHolder extends RecyclerView.ViewHolder {

    protected EditText stuff, price;
    protected CardView card;

    public ExpensesHolder(View itemView) {
        super(itemView);
        stuff = (EditText) itemView.findViewById(R.id.stuff);
        price = (EditText) itemView.findViewById(R.id.price);
        card = (CardView) itemView;
    }
}