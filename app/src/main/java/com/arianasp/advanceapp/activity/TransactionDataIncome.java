package com.arianasp.advanceapp.activity;

/**
 * Created by mycomputer on 27/09/16.
 */

public class TransactionDataIncome {
    private int idIncome;
    public String descriptionIncome;
    public String amountIncome;
    public String dateIncome;

    public TransactionDataIncome(int idIncome,String descriptionIncome, String amountIncome) {
        this.idIncome = idIncome;
        this.descriptionIncome = descriptionIncome;
        this.amountIncome = amountIncome;
    }


    public int getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(int idIncome) {
        this.idIncome = idIncome;
    }

    public String getDescriptionIncome() {
        return descriptionIncome;
    }

    public void setDescriptionIncome(String descriptionIncome) {
        this.descriptionIncome = descriptionIncome;
    }

    public String getAmountIncome() {
        return amountIncome;
    }

    public void setAmountIncome(String amountIncome) {
        this.amountIncome = amountIncome;
    }

    public String getDateIncome() {
        return dateIncome;
    }

    public void setDateIncome(String dateIncome) {
        this.dateIncome = dateIncome;
    }

}
