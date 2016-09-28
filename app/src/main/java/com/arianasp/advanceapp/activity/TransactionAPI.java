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

    Call<TransactionSerialized> getIncomeItem(@Path("idIncome") String incomeItem_id);


    @PUT("/income_Trans/{idIncome}")

    Call<TransactionSerialized> updateIncomeItem(@Path("idIncome") int incomeItem_id, @Body TransactionSerialized incomeItem);


    @POST("/income_Trans")

    Call<TransactionSerialized> saveIncomeItem(@Body TransactionSerialized incomeItem);


    @DELETE("/income_Trans/{idIncome}")

    Call<TransactionSerialized> deleteIncomeItem(@Path("idIncome") String incomeItem);

    //untuk EXPENSES API

    @GET("/expenses_Trans")
    Call<TransactionSerialized> getExpensesItem();


    @GET("/expenses_Trans{idExpense}")

    Call<TransactionSerialized> getExpensesItem(@Path("idExpense") String expensesItem_id);


    @PUT("/expenses_Trans/{idExpense}")

    Call<TransactionSerialized> updateExpensesItem(@Path("idExpense") int expensesItem_id, @Body TransactionSerialized expensesItem);


    @POST("/expenses_Trans")

    Call<TransactionSerialized> saveExpenseItem(@Body TransactionSerialized expensesItem);


    @DELETE("/expenses_Trans/{id}")

    Call<TransactionSerialized> deleteExpensesItem(@Path("idExpense") String expensesItem);
}
