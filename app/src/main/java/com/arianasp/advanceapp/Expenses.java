package com.arianasp.advanceapp;

/**
 * Created by Ariana on 9/25/2016.
 */

public class Expenses {

    protected  String stuf;
    protected  int price;

    public Expenses(String stuf, int price) {
        this.stuf = stuf;
        this.price = price;
    }

    public String getStuf() {
        return stuf;
    }

    public void setStuf(String stuf) {
        this.stuf = stuf;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
