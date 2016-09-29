package com.arianasp.advanceapp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    TextView tvStatus, tvResponses;
    EditText tvDesription,tvAmount,tvStuff,tvPrice;
    DataBaseSQLite db;
    Button btnSync;
    ProgressDialog dialogReg;
    String descIncome, descExpenses, amountIncome, amountExpenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronize);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvResponses = (TextView) findViewById(R.id.tvLastData);
        tvDesription = (EditText)findViewById(R.id.tvDescription);
        tvAmount = (EditText)findViewById(R.id.tvAmount);
        tvStuff = (EditText)findViewById(R.id.tvstuff);
        tvPrice = (EditText)findViewById(R.id.tvprice);
        btnSync = (Button) findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogReg = new ProgressDialog(SynchronizeActivity.this);
                dialogReg.setTitle("Sync dulu bro");
                dialogReg.setMessage("Loading ...");
                dialogReg.setProgress(0);
                getApiIncome();
            }
        });
    }

    private void getApiIncome(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TransactionAPIIncome user_apiIncome = retrofit.create(TransactionAPIIncome.class);

        // // implement interface for get all user
        Call<TransactionSerializedIncome> call = user_apiIncome.getIncomeItem();
        call.enqueue(new Callback<TransactionSerializedIncome>() {

            @Override
            public void onResponse(Call<TransactionSerializedIncome> call, Response<TransactionSerializedIncome> response) {
                int status = response.code();
                tvStatus.setText(String.valueOf(status));
                for(TransactionSerializedIncome.IncomeItem incomeItem : response.body().getIncomeItem()){
                        tvResponses.append(
                                "Id = " + String.valueOf(incomeItem.getIdIncome()) +
                                        System.getProperty("line.separator") +
                                        "Description Income = " + incomeItem.getDescriptionIncome() +
                                        System.getProperty("line.separator") +
                                        "Amount Income = " + incomeItem.getAmountIncome() +
                                        System.getProperty("line.separator")
                        );
                        break;

//                    }else{
////                      postApiIncome();
//                        break;
//                    }
                }
            }

            @Override
            public void onFailure(Call<TransactionSerializedIncome> call, Throwable t) {
                dialogReg.dismiss();
                tvStatus.setText(String.valueOf(t));
            }
        });
    }

//    private void getApiExpenses(){
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        final TransactionAPIIncome user_apiIncome = retrofit.create(TransactionAPIIncome.class);
//
//        // // implement interface for get all user
//        Call<TransactionSerializedIncome> call = user_apiIncome.getExpensesItem();
//        call.enqueue(new Callback<TransactionSerializedIncome>() {
//
//            @Override
//            public void onResponse(Call<TransactionSerializedIncome> call, Response<TransactionSerializedIncome> response) {
//                int status = response.code();
//                tvStatus.setText("");
//                tvStatus.setText(String.valueOf(status));
//                for(TransactionSerializedIncome.ExpenseItem expenseItem : response.body().getExpensesItem()){
//                    if(expenseItem.getDescriptionExpense().toString().equals(tvStuff.getText().toString())){
//                        Toast.makeText(SynchronizeActivity.this, "DATA EXP NA AYA BRO", Toast.LENGTH_LONG).show();
//
//
//                        break;
//                    }else{
////                        postApiExpenses();
//                        break;
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TransactionSerializedIncome> call, Throwable t) {
//                dialogReg.dismiss();
//                tvStatus.setText(String.valueOf(t));
//            }
//
//
//
//        });
//    }

//    private void postApiIncome(){
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        final TransactionAPIIncome postApiIncome = retrofit.create(TransactionAPIIncome.class);
//
//
//
//        // // implement interface for get all user
//        TransactionDataIncome dataPostIncome = new TransactionDataIncome(descIncome,descExpenses,amountIncome,amountExpenses);
//        Gson gsonPAI = new Gson();
//        String json = gsonPAI.toJson(dataPostIncome);
//        Log.e("CEKIDOT", json);
//        Call<TransactionDataIncome> callPI = postApiIncome.saveIncomeItem(dataPostIncome);
//
//        callPI.enqueue(new Callback<TransactionDataIncome>() {
//            @Override
//            public void onResponse(Call<TransactionDataIncome> call, Response<TransactionDataIncome> response) {
//                int status = response.code();
//                dialogReg.dismiss();
//                tvStatus.setText("");
//                tvStatus.setText(String.valueOf(status));
//                Toast.makeText(SynchronizeActivity.this, "POST Income berhasil", Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<TransactionDataIncome> call, Throwable t) {
//                dialogReg.dismiss();
//                tvStatus.setText(String.valueOf(t));
//            }
//        });
//    }
//
//    private void postApiExpenses(){
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        final TransactionAPIIncome postApiExpenses = retrofit.create(TransactionAPIIncome.class);
//
//        // // implement interface for get all user
//
//        TransactionDataIncome dataPostExpenses = new TransactionDataIncome(descIncome,descExpenses,amountIncome,amountExpenses);
//        Gson gsonPAI = new Gson();
//        String json2 = gsonPAI.toJson(dataPostExpenses);
//        Log.e("CEKIDOT", json2);
//        Call<TransactionDataIncome> callPE = postApiExpenses.saveExpensesItem(dataPostExpenses);
//
//        callPE.enqueue(new Callback<TransactionDataIncome>() {
//            @Override
//            public void onResponse(Call<TransactionDataIncome> call, Response<TransactionDataIncome> response) {
//                int status = response.code();
//                dialogReg.dismiss();
//                tvStatus.setText("");
//                tvStatus.setText(String.valueOf(status));
//                Toast.makeText(SynchronizeActivity.this, "POST Expenses berhasil", Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<TransactionDataIncome> call, Throwable t) {
//                tvStatus.setText(String.valueOf(t));
//            }
//        });
//    }
}
