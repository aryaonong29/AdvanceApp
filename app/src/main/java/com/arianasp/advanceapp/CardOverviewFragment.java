package com.arianasp.advanceapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arianasp.advanceapp.database.DataBaseSQLite;


public class CardOverviewFragment extends Fragment {
    DataBaseSQLite db;
    EditText tvDesription,tvAmount,tvStuff,tvPrice;
    Button buttonAddIncome,buttonCancelIncome,buttonAddExpenses,buttonCancelExpenses;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_overview, container, false);
        db = new DataBaseSQLite(getActivity());
        tvDesription = (EditText)view.findViewById(R.id.tvDescription);
        tvAmount = (EditText)view.findViewById(R.id.tvAmount);
        buttonAddIncome = (Button)view.findViewById(R.id.buttonAddIncome);


        buttonAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String des = tvDesription.getText().toString();
                String amo = tvAmount.getText().toString();

                boolean result = db.saveDataIncome(des, amo);
                if (result) {
                    Toast.makeText(getActivity(), "Add Income Success", Toast.LENGTH_SHORT).show();
                    tvDesription.setText("");
                    tvAmount.setText("");
                }else {
                    Toast.makeText(getActivity(), "Add Income Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonCancelIncome = (Button)view.findViewById(R.id.buttonCancelIncome);
        buttonAddExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String des = tvStuff.getText().toString();
                String amo = tvPrice.getText().toString();

                boolean result = db.saveDataExpenses(des, amo);
                if (result) {
                    Toast.makeText(getActivity(), "Add Expenses Success", Toast.LENGTH_SHORT).show();
                    tvStuff.setText("");
                    tvPrice.setText("");
                }else {
                    Toast.makeText(getActivity(), "Add Expenses Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
