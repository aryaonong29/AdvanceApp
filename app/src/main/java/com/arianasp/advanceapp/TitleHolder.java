package com.arianasp.advanceapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ariana on 9/25/2016.
 */

public class TitleHolder  extends RecyclerView.ViewHolder {

    protected TextView title;
    protected CardView card;

    public TitleHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        card = (CardView) itemView;
    }
}
