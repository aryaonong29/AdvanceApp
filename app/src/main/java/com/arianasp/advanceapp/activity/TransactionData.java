package com.arianasp.advanceapp.activity;

/**
 * Created by mycomputer on 27/09/16.
 */

public class TransactionData {
    private int idIncome,idExpenses;
    private String descriptionIncome, getDescriptionExpenses;
    private String amountIncome, amountExpenses;

    public TransactionData(int idIncome, int idExpenses, String descriptionIncome, String getDescriptionExpenses, String amountIncome, String amountExpenses) {
        this.idIncome = idIncome;
        this.idExpenses = idExpenses;
        this.descriptionIncome = descriptionIncome;
        this.getDescriptionExpenses = getDescriptionExpenses;
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

    public String getGetDescriptionExpenses() {
        return getDescriptionExpenses;
    }

    public void setGetDescriptionExpenses(String getDescriptionExpenses) {
        this.getDescriptionExpenses = getDescriptionExpenses;
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
