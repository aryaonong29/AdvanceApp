package com.arianasp.advanceapp.database;

import android.content.Context;
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
    public static final String COL_EX_DES = "STUFF";
    public static final String COL_EX_AMO = "PRICE";

    public static final String TABLE_CREATE_INCOME = "CREATE TABLE " + TABLE_NAME_INCOME + " ( " +
            COL_IN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_IN_DES + " TEXT, " +
            COL_IN_AMO + " TEXT, ";

    public static final String TABLE_CREATE_EXPENSES = "CREATE TABLE " + TABLE_NAME_EXPENSES + " ( " +
            COL_EX_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_EX_DES + " TEXT, " +
            COL_EX_AMO + " TEXT, ";

    public ExpensesDataBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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

    //method untuk save data icncome
    public boolean saveDataIncome(S)
}
