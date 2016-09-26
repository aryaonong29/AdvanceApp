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
import com.arianasp.advanceapp.database.ExpensesDataBaseSQLite;

public class DashboardActivity extends BaseActivity {

    RecyclerView recyclerViewIncome;
    RecyclerView recyclerViewExpenses;
    RecyclerView.Adapter rvAdapterIncome, rvAdapterExpenses;
    RecyclerView.LayoutManager rvLmIncome, rvLmExpenses;
    Cursor cIncome, cExpenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        final ExpensesDataBaseSQLite db = new ExpensesDataBaseSQLite(this);// inisialisasi database di sqlite
        cIncome = db.addIncome();//masukin data ke income
        cExpenses = db.addExpenses();//masukin data ke expenses

        recyclerViewIncome = (RecyclerView) findViewById(R.id.recyclerViewIncome);
        recyclerViewIncome.setHasFixedSize(true);

        recyclerViewExpenses = (RecyclerView) findViewById(R.id.recyclerViewExpenses);
        recyclerViewExpenses.setHasFixedSize(true);//RecyclerView can perform several optimizations
        // if it can know in advance that RecyclerView's size is not affected by the adapter contents.

        rvLmIncome = new LinearLayoutManager(this);
        rvLmExpenses = new LinearLayoutManager(this);
        recyclerViewIncome.setLayoutManager(rvLmIncome);
        recyclerViewExpenses.setLayoutManager(rvLmExpenses);

        rvAdapterIncome = new IncomeAdapter(putIncome());
        recyclerViewIncome.setAdapter(rvAdapterIncome);

        rvAdapterExpenses = new ExpenseAdapter(putExpenses());
        recyclerViewExpenses.setAdapter(rvAdapterExpenses);
    }

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
