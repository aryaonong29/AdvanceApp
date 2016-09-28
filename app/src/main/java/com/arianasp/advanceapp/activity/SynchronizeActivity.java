package com.arianasp.advanceapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arianasp.advanceapp.R;
import com.arianasp.advanceapp.database.DataBaseSQLite;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SynchronizeActivity extends BaseActivity {
    TextView tvStatus;
    EditText tvDesription,tvAmount,tvStuff,tvPrice;
    DataBaseSQLite db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronize);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvDesription = (EditText)findViewById(R.id.tvDescription);
        tvAmount = (EditText)findViewById(R.id.tvAmount);
        tvStuff = (EditText)findViewById(R.id.tvstuff);
        tvPrice = (EditText)findViewById(R.id.tvprice);
    }

    private void getApiIncome(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/incomeTrans")
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
                    if(incomeItem.getDescriptionIncome().toString().equals(tvDesription.getText().toString())
                            && incomeItem.getAmountIncome().toString().equals(tvAmount.getText().toString())){
                        Toast.makeText(SynchronizeActivity.this, "DATA NA AYA BRO", Toast.LENGTH_LONG).show();


                        break;
                    }else{
                        Toast.makeText(SynchronizeActivity.this, "DATA NA LEPAT BRO", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TransactionSerialized> call, Throwable t) {
                tvStatus.setText(String.valueOf(t));
            }



        });
    }

    private void getApiExpenses(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final TransactionAPI user_apiIncome = retrofit.create(TransactionAPI.class);

        // // implement interface for get all user
        Call<TransactionSerialized> call = user_apiIncome.getExpensesItem();
        call.enqueue(new Callback<TransactionSerialized>() {

            @Override
            public void onResponse(Call<TransactionSerialized> call, Response<TransactionSerialized> response) {
                int status = response.code();
                tvStatus.setText("");
                tvStatus.setText(String.valueOf(status));
                for(TransactionSerialized.ExpenseItem expenseItem : response.body().getExpensesItem()){
                    if(expenseItem.getDescriptionExpense().toString().equals(tvStuff.getText().toString())
                            && expenseItem.getAmountExpense().toString().equals(tvPrice.getText().toString())){
                        Toast.makeText(SynchronizeActivity.this, "DATA EXP NA AYA BRO", Toast.LENGTH_LONG).show();


                        break;
                    }else{
                        Toast.makeText(SynchronizeActivity.this, "DATA EXP NA EWEUH BRO", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TransactionSerialized> call, Throwable t) {
                tvStatus.setText(String.valueOf(t));
            }



        });
    }

    private void postApiIncome(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final TransactionAPI postApiIncome = retrofit.create(TransactionAPI.class);



        // // implement interface for get all user
        TransactionData dataPostIncome = new TransactionData(tvDesription,tvAmount,tvStuff,tvPrice);
        Gson gsonPAI = new Gson();
        String json = gsonPAI.toJson(dataPostIncome);
        Log.e("CEKIDOT", json);
        Call<TransactionData> callPI = postApiIncome.saveIncomeItem(dataPostIncome);

        callPI.enqueue(new Callback<TransactionData>() {
            @Override
            public void onResponse(Call<TransactionData> call, Response<TransactionData> response) {
                int status = response.code();
                tvStatus.setText("");
                tvStatus.setText(String.valueOf(status));
                Toast.makeText(SynchronizeActivity.this, "POST Income berhasil", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<TransactionData> call, Throwable t) {
                tvStatus.setText(String.valueOf(t));
            }
        });
    }

    private void postApiExpenses(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final TransactionAPI postapiExpenses = retrofit.create(TransactionAPI.class);

        // // implement interface for get all user
        Call<TransactionData> callPE = postapiExpenses.saveExpensesItem(tvDesription,tvAmount,tvStuff,tvPrice);


        callPE.enqueue(new Callback<TransactionData>() {
            @Override
            public void onResponse(Call<TransactionData> call, Response<TransactionData> response) {
                int status = response.code();
                tvStatus.setText("");
                tvStatus.setText(String.valueOf(status));
                Toast.makeText(SynchronizeActivity.this, "POST Income berhasil", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<TransactionData> call, Throwable t) {
                tvStatus.setText(String.valueOf(t));
            }
        });
    }
}
