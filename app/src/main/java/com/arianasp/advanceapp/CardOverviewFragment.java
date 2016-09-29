package com.arianasp.advanceapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arianasp.advanceapp.activity.TransactionAPIExpenses;
import com.arianasp.advanceapp.activity.TransactionAPIIncome;
import com.arianasp.advanceapp.activity.TransactionDataExpenses;
import com.arianasp.advanceapp.activity.TransactionDataIncome;
import com.arianasp.advanceapp.database.DataBaseSQLite;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.arianasp.advanceapp.R.id.buttonAddExpenses;


public class CardOverviewFragment extends Fragment implements View.OnClickListener  {
    DataBaseSQLite db;
    EditText tvDesription,tvAmount,tvStuff,tvPrice;
    Button buttonAddInc,buttonAddExp;
    String descIncome, descExpenses, amountIncome, amountExpenses;
    ProgressDialog dialogReg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_overview, container, false);
        db = new DataBaseSQLite(getActivity());
        tvDesription = (EditText)view.findViewById(R.id.tvDescription);
        tvAmount = (EditText)view.findViewById(R.id.tvAmount);
        tvStuff = (EditText) view.findViewById(R.id.tvstuff);
        tvPrice = (EditText) view.findViewById(R.id.tvprice);
        buttonAddInc = (Button)view.findViewById(R.id.buttonAddIncome);
        buttonAddInc.setOnClickListener(this);
        buttonAddExp = (Button)view.findViewById(buttonAddExpenses);
        buttonAddExp.setOnClickListener(this);

;       return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAddIncome:
                descIncome = tvDesription.getText().toString();
                amountIncome = tvAmount.getText().toString();
                Gson gsonI = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                        .create();
                Retrofit retrofitI = new Retrofit.Builder()
                        .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/")
                        .addConverterFactory(GsonConverterFactory.create(gsonI))
                        .build();

                final TransactionAPIIncome postApiIncome = retrofitI.create(TransactionAPIIncome.class);

                // // implement interface for get all user
                TransactionDataIncome dataPostIncome = new TransactionDataIncome(descIncome,amountIncome);
                Gson gsonPAI = new Gson();
                String jsonI = gsonPAI.toJson(dataPostIncome);
                Log.e("CEK income", jsonI);
                Call<TransactionDataIncome> callPI = postApiIncome.saveIncomeItem(dataPostIncome);

                callPI.enqueue(new Callback<TransactionDataIncome>() {
                    @Override
                    public void onResponse(Call<TransactionDataIncome> call, Response<TransactionDataIncome> response) {
                        int status = response.code();
                        Toast.makeText(getActivity(), "POST Income berhasil", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<TransactionDataIncome> call, Throwable t) {
                        dialogReg.dismiss();
                    }
                });

                boolean resultInc = db.saveDataIncome(descIncome, amountIncome);
                if (resultInc) {
                    Toast.makeText(getActivity(), "Inc Sukses Bro", Toast.LENGTH_SHORT).show();
                    tvDesription.setText("");
                    tvAmount.setText("");
                }else {
                    Toast.makeText(getActivity(), "Hapunten Inc Gagal Bro", Toast.LENGTH_SHORT).show();
                }
                break;
            case buttonAddExpenses:
                descExpenses = tvStuff.getText().toString();
                amountExpenses = tvPrice.getText().toString();
                Gson gsonE = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                        .create();

                Retrofit retrofitE = new Retrofit.Builder()
                        .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/")
                        .addConverterFactory(GsonConverterFactory.create(gsonE))
                        .build();

                final TransactionAPIExpenses postApiExpenses = retrofitE.create(TransactionAPIExpenses.class);

                // // implement interface for get all user
                TransactionDataExpenses dataPostExpenses = new TransactionDataExpenses(descExpenses,amountExpenses);
                Gson gsonPAE = new Gson();
                String jsonE = gsonPAE.toJson(dataPostExpenses);
                Log.e("CEK expenses", jsonE);

                Call<TransactionDataExpenses> callPE = postApiExpenses.saveExpensesItem(dataPostExpenses);

                callPE.enqueue(new Callback<TransactionDataExpenses>() {
                    @Override
                    public void onResponse(Call<TransactionDataExpenses> call, Response<TransactionDataExpenses> response) {
                        int status = response.code();
                        Toast.makeText(getActivity(), "POST Expenses berhasil", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<TransactionDataExpenses> call, Throwable t) {
                        dialogReg.dismiss();
                    }
                });

                    boolean resultExp = db.saveDataExpenses(descExpenses, amountExpenses);
                if (resultExp) {
                    Toast.makeText(getActivity(), "Exp Sukses Bro", Toast.LENGTH_SHORT).show();
                    tvStuff.setText("");
                    tvPrice.setText("");
                } else {
                    Toast.makeText(getActivity(), "Hapunten Exp Gagal Bro", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}
