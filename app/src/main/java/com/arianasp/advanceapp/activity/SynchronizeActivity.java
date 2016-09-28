package com.arianasp.advanceapp.activity;

import android.os.Bundle;

import com.arianasp.advanceapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SynchronizeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronize);
    }

    private void getApiIncome(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-f6513-login312.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TransactionAPI user_apiIncome = retrofit.create(TransactionAPI.class);

        // // implement interface for get all user
        Call<TransactionSerialized> call = user_apiIncome.getIncomeItem();
        call.enqueue(new Callback<TransactionSerialized>() {

            @Override
            public void onResponse(Call<TransactionSerialized> call, Response<TransactionSerialized> response) {
                int status = response.code();
                for(TransactionSerialized.IncomeItem incomeItem : response.body().getIncomeItem()){
//                    if(incomeItem.getDescriptionIncome().toString().equals())
                }
            }

            @Override
            public void onFailure(Call<TransactionSerialized> call, Throwable t) {

            }



        });
    }
}
