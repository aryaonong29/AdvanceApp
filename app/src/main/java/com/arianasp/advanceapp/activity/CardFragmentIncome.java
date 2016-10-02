package com.arianasp.advanceapp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arianasp.advanceapp.R;
import com.arianasp.advanceapp.database.DataBaseSQLite;


public class CardFragmentIncome extends Fragment implements View.OnClickListener  {
    DataBaseSQLite db;
    EditText tvDesription,tvAmount,tvDateInc;
    Button buttonAddInc;
    String descIncome,amountIncome,dateIncome;
    ProgressDialog dialogReg;
    TextView tvStatusInc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_income, container, false);
        db = new DataBaseSQLite(getActivity());
        tvDesription = (EditText)view.findViewById(R.id.tvDescription);
        tvAmount = (EditText)view.findViewById(R.id.tvAmount);
        tvDateInc = (EditText) view.findViewById(R.id.tvDateInc);
        tvStatusInc =(TextView)view.findViewById(R.id.tvstatusinc);
        buttonAddInc = (Button)view.findViewById(R.id.buttonAddIncome);
        buttonAddInc.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAddIncome:
                descIncome = tvDesription.getText().toString();
                amountIncome = tvAmount.getText().toString();
                dateIncome = tvDateInc.getText().toString();
                boolean resultInc = db.saveDataIncome(descIncome, amountIncome,dateIncome);
                if (resultInc) {
                    Toast.makeText(getActivity(), "Inc Sukses Bro", Toast.LENGTH_SHORT).show();
                    tvDesription.setText("");
                    tvAmount.setText("");
                    tvDateInc.setText("");
                    tvStatusInc.setText("");

                }else {
                    Toast.makeText(getActivity(), "Hapunten Inc Gagal Bro", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


}
