package com.arianasp.advanceapp.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mycomputer on 29/09/16.
 */

public class TransactionSerializedExpenses {
    @SerializedName("expenses_Trans")
    public List<TransactionSerializedExpenses.ExpenseItem> expenseItem;

    public List<TransactionSerializedExpenses.ExpenseItem> getExpensesItem() {
        return expenseItem;
    }
    public void setExpenseItem(List<TransactionSerializedExpenses.ExpenseItem> expenseItem){
        this.expenseItem = expenseItem;
    }
    public TransactionSerializedExpenses(List<TransactionSerializedExpenses.ExpenseItem> expenseItem){
        this.expenseItem = expenseItem;
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
