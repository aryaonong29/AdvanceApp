package com.arianasp.advanceapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ariana on 9/25/2016.
 */

public class ExpensesDataBaseSQLite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "expenses.db";
    public static final int DATABASE_VERSION = 1;

    
    public static final String TABLE_NAME_INCOME = "incomes";
    public static final String COL_IN_ID = "ID";
    public static final String COL_IN_DES = "DESCRIPTION";
    public static final String COL_IN_AMO = "AMOUNT";

    public static final String TABLE_NAME_EXPENSES = "expenses";
    public static final String COL_EX_ID = "ID";
    public static final String COL_EX_DES = "DESCRIPTION";
    public static final String COL_EX_PR = "PRICE";

    public static final String TABLE_CREATE_INCOME = "CREATE TABLE " + TABLE_NAME_INCOME + " ( " +
            COL_IN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_IN_DES + " TEXT, " +
            COL_IN_AMO + " TEXT, ";

    public static final String TABLE_CREATE_EXPENSES = "CREATE TABLE " + TABLE_NAME_EXPENSES + " ( " +
            COL_EX_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_EX_DES + " TEXT, " +
            COL_EX_PR + " TEXT, ";

    public ExpensesDataBaseSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_INCOME);
        db.execSQL(TABLE_CREATE_EXPENSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_INCOME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EXPENSES);
    }

    //method untuk save data income
    public boolean saveDataIncome(String desc,String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVal = new ContentValues();
        cVal.put(COL_IN_DES, desc);
        cVal.put(COL_IN_AMO, amount);
        long temp = db.insert(TABLE_NAME_INCOME,null,cVal);
        return temp != -1;
    }

    //method untuk save data expenses
    public boolean saveDataExpenses(String desc,String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVal = new ContentValues();
        cVal.put(COL_EX_DES, desc);
        cVal.put(COL_EX_PR, price);
        long temp = db.insert(TABLE_NAME_EXPENSES,null,cVal);
        return temp != -1;
    }

    public Cursor addIncome() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor income = db.rawQuery("SELECT * FROM " + TABLE_NAME_INCOME, null);
        return income;
    }

    public Cursor addExpenses() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor expense = db.rawQuery("SELECT * FROM " + TABLE_NAME_EXPENSES, null);
        return expense;
    }

    public boolean updateIncome(String id, String desc, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVal = new ContentValues();
        cVal.put(COL_IN_ID, id);
        cVal.put(COL_IN_DES, desc);
        cVal.put(COL_IN_AMO, amount);
        db.update(TABLE_NAME_INCOME, cVal, "ID = ? ", new String[]{id});
        return true;
    }

    public boolean updateExpense(String id, String desc, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVal = new ContentValues();
        cVal.put(COL_EX_ID, id);
        cVal.put(COL_EX_DES, desc);
        cVal.put(COL_EX_PR, price);
        db.update(TABLE_NAME_EXPENSES, cVal, "ID = ? ", new String[]{id});
        return true;
    }

    public Integer deleteIncome(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_INCOME, "ID = ?", new String[] {id});
    }

    public Integer deleteExpense(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_EXPENSES, "ID = ?", new String[] {id});
    }
}
