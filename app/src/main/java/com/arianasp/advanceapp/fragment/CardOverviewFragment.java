package com.arianasp.advanceapp.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arianasp.advanceapp.R;
import com.arianasp.advanceapp.database.DataBaseSQLite;

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
                    if(descIncome.length()==0){
                        Toast.makeText(getActivity(),"desc tong dikosongkeun bray", Toast.LENGTH_LONG).show();
                    }
                    else if(amountIncome.length()==0){
                        Toast.makeText(getActivity(),"amount tong dikosongkeun bray", Toast.LENGTH_LONG).show();
                    }
                    else if(descIncome.length() ==0 || amountIncome.length() ==0){
                        Toast.makeText(getActivity(),"isi heula desc sareng amount na kasep",Toast.LENGTH_LONG).show();
                    }
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
                    if(descExpenses.length()==0){
                        Toast.makeText(getActivity(),"desc tong dikosongkeun bray", Toast.LENGTH_LONG).show();
                    }
                    else if(amountExpenses.length()==0){
                        Toast.makeText(getActivity(),"amount tong dikosongkeun bray", Toast.LENGTH_LONG).show();
                    }
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
