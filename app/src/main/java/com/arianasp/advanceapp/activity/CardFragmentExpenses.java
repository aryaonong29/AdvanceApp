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

import static com.arianasp.advanceapp.R.id.buttonAddExpenses;


public class CardFragmentExpenses extends Fragment implements View.OnClickListener  {
    DataBaseSQLite db;
    EditText tvStuff,tvPrice,tvDateExp;
    Button buttonAddExp;
    String descExpenses,amountExpenses,dateExpenses;
    ProgressDialog dialogReg;
    TextView tvStatusExp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_expenses, container, false);
        db = new DataBaseSQLite(getActivity());
        tvStuff = (EditText) view.findViewById(R.id.tvstuff);
        tvPrice = (EditText) view.findViewById(R.id.tvprice);
        tvDateExp = (EditText) view.findViewById(R.id.tvDateExp);
        tvStatusExp =(TextView)view.findViewById(R.id.tvstatusexp);
        buttonAddExp = (Button)view.findViewById(buttonAddExpenses);
        buttonAddExp.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
                descExpenses = tvStuff.getText().toString();
                amountExpenses = tvPrice.getText().toString();
                dateExpenses = tvDateExp.getText().toString();
                boolean resultExp = db.saveDataExpenses(descExpenses, amountExpenses,dateExpenses);
                if (resultExp) {
                    Toast.makeText(getActivity(), "Exp Sukses Bro", Toast.LENGTH_SHORT).show();
                    tvStuff.setText("");
                    tvPrice.setText("");
                    tvDateExp.setText("");
                } else {
                    Toast.makeText(getActivity(), "Hapunten Exp Gagal Bro", Toast.LENGTH_SHORT).show();
                }
    }


}
