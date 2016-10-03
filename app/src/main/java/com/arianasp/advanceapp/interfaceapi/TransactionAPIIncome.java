package com.arianasp.advanceapp.interfaceapi;

import com.arianasp.advanceapp.pojo.TransactionSerializedIncome;
import com.arianasp.advanceapp.pojo.TransactionDataIncome;

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

public interface TransactionAPIIncome {

    //UNTUK INCOME API

    @GET("/income_Trans")
    Call<TransactionSerializedIncome> getIncomeItem();


    @GET("/income_Trans{idIncome}")

    Call<TransactionDataIncome> getIncomeItem(@Path("idIncome") String incomeItem_idIncome);


    @PUT("/income_Trans/{idIncome}")

    Call<TransactionDataIncome> updateIncomeItem(@Path("idIncome") int incomeItem_idIncome, @Body TransactionDataIncome incomeItem);


    @POST("/income_Trans")

    Call<TransactionDataIncome> saveIncomeItem(@Body TransactionDataIncome incomeItem);


    @DELETE("/income_Trans/{idIncome}")

    Call<TransactionDataIncome> deleteIncomeItem(@Path("idIncome") String incomeItem_idIncome);





}
