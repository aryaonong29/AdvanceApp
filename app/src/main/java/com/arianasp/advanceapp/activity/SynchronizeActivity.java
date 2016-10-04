package com.arianasp.advanceapp.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arianasp.advanceapp.R;
import com.arianasp.advanceapp.database.DataBaseSQLite;
import com.arianasp.advanceapp.interfaceapi.TransactionAPIIncome;
import com.arianasp.advanceapp.pojo.TransactionDataIncome;
import com.arianasp.advanceapp.pojo.TransactionSerializedIncome;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.arianasp.advanceapp.R.id.tvAmount;

public class SynchronizeActivity extends BaseActivity {
    EditText etDesc,etAmount;
    TextView tvRespond,tvStatus;
    Button btnSync;
    DataBaseSQLite db;
    TransactionDataIncome tid;
    Cursor curInc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronize);
        etDesc = (EditText) findViewById(R.id.tvDescription);
        etAmount = (EditText) findViewById(tvAmount);
        tvRespond = (TextView) findViewById(R.id.tvLastData);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        db = new DataBaseSQLite(this);
//        tid = new TransactionDataIncome();
        curInc = db.addIncome();
        db = new DataBaseSQLite(this);
        btnSync = (Button) findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    getApiIncome();
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void getApiIncome() throws JSONException{
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final TransactionAPIIncome getApiIncome = retrofit.create(TransactionAPIIncome.class);
        if(curInc.getCount() > 0){
            curInc.moveToFirst();
            do{
                final Integer id = new Integer(curInc.getInt(0));
                Call<TransactionDataIncome> call = getApiIncome.saveIncomeItem(new TransactionDataIncome(tid.getDescriptionIncome(),tid.getAmountIncome()));
                call.enqueue(new Callback<TransactionDataIncome>() {
                    @Override
                    public void onResponse(Call<TransactionDataIncome> call, Response<TransactionDataIncome> response) {
                        System.out.println("Response status code: " + response.code());
                        int cekId = response.body().(id);
                        int curPos = curInc.getPosition();

                        if(cekId != id ){
                            postApiIncome(pos);
                        }
                        else if(cekId == id){
                            putApiIncome(pos);
                        }
                    }

                    @Override
                    public void onFailure(Call<TransactionDataIncome> call, Throwable t) {
                        tvRespond.setText(String.valueOf(t));
                    }
                });
                curInc.moveToNext();
            }while(!curInc.isLast());
        }
        else{
            Toast.makeText(SynchronizeActivity.this,"nothing to sync",Toast.LENGTH_LONG).show();
        }

    }

    private void putApiIncome() throws JSONException{
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final TransactionAPIIncome postApiIncome = retrofit.create(TransactionAPIIncome.class);
    }

    private void postApiIncome() throws JSONException{
        int count = 0;

        dialogReg = new ProgressDialog(SynchronizeActivity.this);
        dialogReg.setTitle("Syncronize dulu bro");
        dialogReg.setMessage("Loading ...");
        dialogReg.setProgress(0);

        dialogReg.show();
        count++;

        Integer current_status = (int) ((count / (float) curInc.getColumnCount()) * 100);
        dialogReg.setProgress(current_status);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-b22195-advanceapp1.apiary-mock.com/expenseTrans")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final TransactionAPIIncome postApiIncome = retrofit.create(TransactionAPIIncome.class);
        // // implement interface for get all user
        TransactionDataIncome dataPostIncome = new TransactionDataIncome(descIncome,amountIncome);
        Gson gsonPAI = new Gson();
        String json = gsonPAI.toJson(dataPostIncome);
        Log.e("CEKIDOT", json);

        TransactionDataIncome curData = new TransactionDataIncome(curInc.getString(1), curInc.getString(2));

        Call<TransactionDataIncome> callPI = postApiIncome.saveIncomeItem(curData);
        callPI.enqueue(new Callback<TransactionDataIncome>() {
            @Override
            public void onResponse(Call<TransactionDataIncome> call, Response<TransactionDataIncome> response) {
                int status = response.code();
                for(curInc.moveToFirst(); ! curInc.isAfterLast(); curInc.moveToNext()) {
                    tvResponses.setText(String.valueOf(curInc.getPosition()));
                    DataBaseSQLite myDb = new DataBaseSQLite(SynchronizeActivity.this);
                    //myDb.updateIncome(String.valueOf(curInc.getInt(0)), tvResponses.getText().toString());
                    Toast.makeText(SynchronizeActivity.this, String.valueOf(curInc.getPosition()), Toast.LENGTH_SHORT).show();
                }
//                tvResponses.setText(String.valueOf(status)+ " : last income sync : " + String.valueOf(curInc.getPosition()));
                if (status==201) {
                    Toast.makeText(SynchronizeActivity.this, "Sync Success", Toast.LENGTH_SHORT).show();
                } else if (status==400) {
                    Toast.makeText(SynchronizeActivity.this, "Sync Failed", Toast.LENGTH_SHORT).show();
                }
                if (dialogReg.isShowing()) dialogReg.dismiss();

            }

            @Override
            public void onFailure(Call<TransactionDataIncome> call, Throwable t) {
                if(dialogReg.isShowing()){
                    dialogReg.dismiss();
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(SynchronizeActivity.this);

                alert.setCancelable(false).setTitle("Synchronize").setMessage("fails synchronize")
                        .setPositiveButton("Skip", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SynchronizeActivity.this, "Skip.", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    postApiIncome();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                dialog.dismiss();
                                Toast.makeText(SynchronizeActivity.this, "Internet Mati Coy", Toast.LENGTH_SHORT).show();
                            }
                        });
                alert.show();

            }
        });
    }
}
