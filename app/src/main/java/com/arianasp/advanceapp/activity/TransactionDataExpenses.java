package com.arianasp.advanceapp.activity;

/**
 * Created by mycomputer on 29/09/16.
 */

public class TransactionDataExpenses {
    private int idExpenses;
    public String descriptionExpenses;
    public String amountExpenses;

    public TransactionDataExpenses(String descriptionExpenses, String amountExpenses) {
        this.descriptionExpenses = descriptionExpenses;
        this.amountExpenses = amountExpenses;
    }

    public int getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(int idExpenses) {
        this.idExpenses = idExpenses;
    }

    public String getDescriptionExpenses() {
        return descriptionExpenses;
    }

    public void setDescriptionExpenses(String descriptionExpenses) {
        this.descriptionExpenses = descriptionExpenses;
    }

    public String getAmountExpenses() {
        return amountExpenses;
    }

    public void setAmountExpenses(String amountExpenses) {
        this.amountExpenses = amountExpenses;
    }




}
