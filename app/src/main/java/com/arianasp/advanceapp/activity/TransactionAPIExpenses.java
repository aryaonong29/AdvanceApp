package com.arianasp.advanceapp.activity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by mycomputer on 29/09/16.
 */

public interface TransactionAPIExpenses {
    //untuk EXPENSES API

    @GET("/expenses_Trans")
    Call<TransactionSerializedExpenses> getExpensesItem();


    @GET("/expenses_Trans{idExpense}")

    Call<TransactionDataExpenses> getExpensesItem(@Path("idExpense") String expensesItem_idExpenses);


    @PUT("/expenses_Trans/{idExpense}")

    Call<TransactionDataExpenses> updateExpensesItem(@Path("idExpense") int expensesItem_idExpenses, @Body TransactionDataExpenses expensesItem);


    @POST("/expenses_Trans")

    Call<TransactionDataExpenses> saveExpensesItem(@Body TransactionDataExpenses expensesItem);


    @DELETE("/expenses_Trans/{id}")

    Call<TransactionDataExpenses> deleteExpensesItem(@Path("idExpense") String expensesItem_idExpenses);
}
