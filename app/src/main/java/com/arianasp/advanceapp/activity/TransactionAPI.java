package com.arianasp.advanceapp.activity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by mycomputer on 27/09/16.
 */

public interface TransactionAPI {

    //UNTUK INCOME API

    @GET("/income_Trans")
    Call<TransactionSerialized> getIncomeItem();


    @GET("/income_Trans{idIncome}")

    Call<TransactionData> getIncomeItem(@Path("idIncome") String incomeItem_idIncome);


    @PUT("/income_Trans/{idIncome}")

    Call<TransactionData> updateIncomeItem(@Path("idIncome") int incomeItem_idIncome, @Body TransactionData incomeItem);


    @POST("/income_Trans")

    Call<TransactionData> saveIncomeItem(@Body TransactionData incomeItem);


    @DELETE("/income_Trans/{idIncome}")

    Call<TransactionData> deleteIncomeItem(@Path("idIncome") String incomeItem_idIncome);




    //untuk EXPENSES API

    @GET("/expenses_Trans")
    Call<TransactionSerialized> getExpensesItem();


    @GET("/expenses_Trans{idExpense}")

    Call<TransactionData> getExpensesItem(@Path("idExpense") String expensesItem_idExpenses);


    @PUT("/expenses_Trans/{idExpense}")

    Call<TransactionData> updateExpensesItem(@Path("idExpense") int expensesItem_idExpenses, @Body TransactionData expensesItem);


    @POST("/expenses_Trans")

    Call<TransactionData> saveExpensesItem(@Body TransactionData expensesItem);


    @DELETE("/expenses_Trans/{id}")

    Call<TransactionData> deleteExpensesItem(@Path("idExpense") String expensesItem_idExpenses);
}
