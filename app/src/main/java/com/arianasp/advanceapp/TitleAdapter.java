package com.arianasp.advanceapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariana on 9/25/2016.
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleHolder> {

    private List<TitleCard> title;

    public TitleAdapter(List<TitleCard> title){
        this.title = new ArrayList<TitleCard>();
        this.title.addAll(title);
    }


    @Override
    public TitleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.cardview2, viewGroup, false);
        return new TitleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TitleHolder titleHolder, int i) {
        TitleCard titleCard = title.get(i);

        titleHolder.title.setText(titleCard.getTitle());
    }


    @Override
    public int getItemCount() {
        return title.size();
    }
}
