package com.arianasp.advanceapp.activity;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arianasp.advanceapp.R;
import com.arianasp.advanceapp.database.DataBaseSQLite;

public class DashboardActivity extends BaseActivity {
    RecyclerView recyclerViewIncome;
    RecyclerView recyclerViewExpenses;
    RecyclerView.Adapter rvAdapterIncome, rvAdapterExpenses;
    RecyclerView.LayoutManager rvLmIncome, rvLmExpenses;
    Cursor cIncome, cExpenses,cIn,cExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.setTitle("Dasboard");


        final DataBaseSQLite db = new DataBaseSQLite(this);// inisialisasi database di sqlite
        cIncome = db.addIncome();//masukin data ke income
        cIn = db.addIncome();
        cExpenses = db.addExpenses();//masukin data ke expenses
        cExp = db.addExpenses();

        recyclerViewIncome = (RecyclerView) findViewById(R.id.recyclerViewIncome);
        recyclerViewIncome.setHasFixedSize(true);

        recyclerViewExpenses = (RecyclerView) findViewById(R.id.recyclerViewExpenses);
        recyclerViewExpenses.setHasFixedSize(true);//RecyclerView can perform several optimizations
        // if it can know in advance that RecyclerView's size is not affected by the adapter contents.

        //LinearLayoutManager
        //Hanya mendukung satu kolom jika itu orientasinya vertical dan satu baris jika orientasinya horizontal.
        rvLmIncome = new LinearLayoutManager(this);
        rvLmExpenses = new LinearLayoutManager(this);
        recyclerViewIncome.setLayoutManager(rvLmIncome);
        recyclerViewExpenses.setLayoutManager(rvLmExpenses);

        rvAdapterIncome = new IncomeAdapter(putIncome());
        recyclerViewIncome.setAdapter(rvAdapterIncome);

        rvAdapterExpenses = new ExpenseAdapter(putExpenses());
        recyclerViewExpenses.setAdapter(rvAdapterExpenses);

        int amountIncome = 0;
        TextView totalI = (TextView) findViewById(R.id.tv_total_I);
        while (cIn.moveToNext()) {
            amountIncome += cIn.getInt(cIn.getColumnIndex("AMOUNT"));
        }
        totalI.setText("Rp. " + String.valueOf(amountIncome));

        int amountExpenses = 0;
        TextView totalE = (TextView) findViewById(R.id.tv_total_E);
        while (cExp.moveToNext()) {
            amountExpenses += cExp.getInt(cExp.getColumnIndex("AMOUNT"));
        }
        totalE.setText("Rp. " + String.valueOf(amountExpenses));

        TextView balance = (TextView) findViewById(R.id.tv_balancetotal);
        balance.setText("Rp. " + String.valueOf(amountIncome-amountExpenses));
    }

    //mthod Cursor interface, that provides random read-write access to the result set returned by a database query.
    private String [] putIncome(){
        String [] incomeA = new String[cIncome.getCount()];
        while(cIncome.moveToNext()){
            incomeA[cIncome.getPosition()] = cIncome.getString(1)+" "+cIncome.getString(2);
        }
        return incomeA;
    }

    public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.ViewHolder>{
        private String [] dataI;

        public class ViewHolder extends RecyclerView.ViewHolder{
            public CardView cvIncome;
            public TextView tvIncome;

            public ViewHolder(View v){
                super(v);
                cvIncome = (CardView) v.findViewById(R.id.cvIncome);
                tvIncome = (TextView) v.findViewById(R.id.tvIncome);
            }
        }

        public IncomeAdapter(String [] data){
            dataI = data;
        }

        @Override
        public IncomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_income, parent, false);
            ViewHolder vhdr = new ViewHolder(view);
            return vhdr;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvIncome.setText(dataI[position]);
        }

        @Override
        public int getItemCount() {
            return dataI.length;
        }
    }


    //method untuk atur dan menampilkan data untuk expenses
    private String[] putExpenses(){
        String[] expensesA = new String[cExpenses.getCount()];
        while(cExpenses.moveToNext()){
            expensesA[cExpenses.getPosition()] = cExpenses.getString(1)+" "+cExpenses.getString(2);
        }
        return expensesA;
    }

    public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder>{
        private String[] dataE;

        public class ViewHolder extends RecyclerView.ViewHolder{
            public  CardView cvExpenses;
            public TextView tvExpenses;

            public ViewHolder(View v){
                super(v);
                cvExpenses = (CardView) v.findViewById(R.id.cvExpenses);
                tvExpenses = (TextView) v.findViewById(R.id.tvExpenses);
            }
        }

        public ExpenseAdapter(String[] data){
            dataE = data;
        }

        @Override
        public ExpenseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_expense, parent, false);
            ViewHolder vhdr = new ViewHolder(v);
            return vhdr;
        }

        @Override
        public void onBindViewHolder(ExpenseAdapter.ViewHolder holder, int position) {
            holder.tvExpenses.setText(dataE[position]);
        }

        @Override
        public int getItemCount() {
            return dataE.length;
        }
    }



}
