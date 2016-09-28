package com.arianasp.advanceapp.activity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mycomputer on 28/09/16.
 */

public class TransactionSerialized {
    @SerializedName("incomeTrans")
    public List<IncomeItem> incomeItem;
    public List<IncomeItem> getIncomeItem() { return incomeItem;}
    public void setIncomeItem(List<IncomeItem> incomeItem){ this.incomeItem = incomeItem;}

    @SerializedName("expensesTrans")
    public List<ExpenseItem> expenseItem;
    public List<ExpenseItem> getExpensesItem() { return expenseItem;}
    public void setExpenseItem(List<ExpenseItem> expenseItem){ this.expenseItem = expenseItem;}

    public class IncomeItem{
        private int idIncome;
        private String descriptionIncome;
        private String amountIncome;

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

    public class ExpenseItem{
        private int idExpense;
        private String descriptionExpense;
        private String amountExpense;

        public int getIdExpense() {
            return idExpense;
        }

        public void setIdExpense(int idExpense) {
            this.idExpense = idExpense;
        }

        public String getDescriptionExpense() {
            return descriptionExpense;
        }

        public void setDescriptionExpense(String descriptionExpense) {
            this.descriptionExpense = descriptionExpense;
        }

        public String getAmountExpense() {
            return amountExpense;
        }

        public void setAmountExpense(String amountExpense) {
            this.amountExpense = amountExpense;
        }
    }

}
