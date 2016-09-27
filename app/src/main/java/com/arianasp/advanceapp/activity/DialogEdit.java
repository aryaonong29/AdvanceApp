package com.arianasp.advanceapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arianasp.advanceapp.R;

/**
 * Created by mycomputer on 27/09/16.
 */

public class DialogEdit extends DialogFragment {
    EditText edDesc;
    EditText edAmount;
    Button btnUpdate, btnDelete;
    Data data;
    DialogEditCommunicator communicator;

    public DialogEdit() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_edit, container, false);
        edDesc = (EditText) v.findViewById(R.id.edDesc);
        edAmount = (EditText) v.findViewById(R.id.edAmount);
        btnUpdate = (Button) v.findViewById(R.id.btnUpdate);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });


        btnDelete = (Button) v.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (DialogEditCommunicator) context;
    }

    public void sendData() {
        if (isValid()) {
            Data data = new Data(edDesc.getText().toString(), edAmount.getText().toString());
            communicator.sendData(data);
            getDialog().dismiss();
        }
    }

    public boolean isValid() {
        boolean isValid = true;
        if (TextUtils.isEmpty(edDesc.getText().toString())) {
            isValid = false;
            edDesc.setError("please fill the description");
        }
        if (TextUtils.isEmpty(edAmount.getText().toString())) {
            isValid = false;
            edAmount.setError("please fill the amount");
        }

        return isValid;
    }
}
