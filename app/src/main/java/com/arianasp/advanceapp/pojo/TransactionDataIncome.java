package com.arianasp.advanceapp.pojo;

/**
 * Created by mycomputer on 27/09/16.
 */

public class TransactionDataIncome {
    private int idIncome;
    private String descriptionIncome;
    private String amountIncome;
    private String date;

    public TransactionDataIncome(String descriptionIncome, String amountIncome) {
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



}
