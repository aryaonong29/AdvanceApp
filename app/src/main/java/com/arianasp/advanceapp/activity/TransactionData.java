package com.arianasp.advanceapp.activity;

/**
 * Created by mycomputer on 27/09/16.
 */

public class TransactionData {
    private int idIncome,idExpenses;
    public String descriptionIncome, descriptionExpenses;
    public String amountIncome, amountExpenses;

    public TransactionData(String descriptionIncome, String descriptionExpenses, String amountIncome, String amountExpenses) {
        this.descriptionIncome = descriptionIncome;
        this.descriptionExpenses = descriptionExpenses;
        this.amountIncome = amountIncome;
        this.amountExpenses = amountExpenses;
    }

    public int getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(int idIncome) {
        this.idIncome = idIncome;
    }

    public int getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(int idExpenses) {
        this.idExpenses = idExpenses;
    }

    public String getDescriptionIncome() {
        return descriptionIncome;
    }

    public void setDescriptionIncome(String descriptionIncome) {
        this.descriptionIncome = descriptionIncome;
    }

    public String getDescriptionExpenses() {
        return descriptionExpenses;
    }

    public void setGetDescriptionExpenses(String descriptionExpenses) {
        this.descriptionExpenses = descriptionExpenses;
    }

    public String getAmountIncome() {
        return amountIncome;
    }

    public void setAmountIncome(String amountIncome) {
        this.amountIncome = amountIncome;
    }

    public String getAmountExpenses() {
        return amountExpenses;
    }

    public void setAmountExpenses(String amountExpenses) {
        this.amountExpenses = amountExpenses;
    }
}
