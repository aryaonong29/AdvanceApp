package com.arianasp.advanceapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ariana on 9/25/2016.
 */

public class DataBaseSQLite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "expenses.db";
    public static final int DATABASE_VERSION = 1;


    public static final String TABLE_NAME_INCOME = "incomes";
    public static final String COL_IN_ID = "ID";
    public static final String COL_IN_DES = "DESCRIPTION";
    public static final String COL_IN_AMO = "AMOUNT";
    public static final String COL_IN_DATE = "DATE";

    public static final String TABLE_NAME_EXPENSES = "expenses";
    public static final String COL_EX_ID = "ID";
    public static final String COL_EX_DES = "DESCRIPTION";
    public static final String COL_EX_AMO = "AMOUNT";
    public static final String COL_EX_DATE = "DATE";


    public static final String TABLE_NAME_TEMPORARY = "temporary";
    public static final String COL_TEMP_ID ="ID";
    public static final String COL_TEMP_CURDATA ="CURDATA";
    public static final String COL_TEMP_NAME ="TABELNAME";

    public static final String TABLE_CREATE_INCOME = "CREATE TABLE " + TABLE_NAME_INCOME + " ( " +
            COL_IN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_IN_DES + " TEXT, " +
            COL_IN_AMO + " TEXT, " +
            COL_IN_DATE + " TEXT); ";

    public static final String TABLE_CREATE_EXPENSES = "CREATE TABLE " + TABLE_NAME_EXPENSES + " ( " +
            COL_EX_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_EX_DES + " TEXT, " +
            COL_EX_AMO + " TEXT, " +
            COL_IN_DATE + " TEXT); ";

    public static final String TABLE_CREATE_TEMPORARY = "CREATE TABLE " + TABLE_NAME_TEMPORARY + " ( " +
            COL_TEMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_TEMP_CURDATA + " TEXT, " +
            COL_TEMP_NAME + " TEXT); ";

    public DataBaseSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //This method not only insert data , but also used to update or modify already existing data in database using bind arguments
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_INCOME);
        db.execSQL(TABLE_CREATE_EXPENSES);
        db.execSQL(TABLE_CREATE_TEMPORARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_INCOME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EXPENSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TEMPORARY);
        onCreate(db);
    }

    //method untuk save data income
    public boolean saveDataIncome(String desc,String amount,String date){
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        ContentValues cVal = new ContentValues(); //ContentValues : Creates an empty set of values using the default initial size
        //put : Adds a value to the set.
        cVal.put(COL_IN_DES, desc);
        cVal.put(COL_IN_AMO, amount);
        cVal.put(COL_IN_DATE, date);
        long temp = db.insert(TABLE_NAME_INCOME,null,cVal);//Convenience method for inserting a row into the database.
        return temp != -1;
    }

    //method untuk save data expenses
    public boolean saveDataExpenses(String desc,String amount,String date){
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        ContentValues cVal = new ContentValues();//ContentValues : Creates an empty set of values using the default initial size
        //put : Adds a value to the set.
        cVal.put(COL_EX_DES, desc);
        cVal.put(COL_EX_AMO, amount);
        cVal.put(COL_EX_DATE, date);
        long temp = db.insert(TABLE_NAME_EXPENSES,null,cVal);//Convenience method for inserting a row into the database.
        return temp != -1;
    }

    public Cursor addIncome() {
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        Cursor income = db.rawQuery("SELECT * FROM " + TABLE_NAME_INCOME, null);//Runs the provided SQL and returns a Cursor over the result set.
        return income;
    }

    public Cursor addExpenses() {
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        Cursor expense = db.rawQuery("SELECT * FROM " + TABLE_NAME_EXPENSES, null);//Runs the provided SQL and returns a Cursor over the result set.
        return expense;
    }

    public boolean updateIncome(String id, String desc, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        ContentValues cVal = new ContentValues();//ContentValues : Creates an empty set of values using the default initial size
        //put : Adds a value to the set.
        cVal.put(COL_IN_ID, id);
        cVal.put(COL_IN_DES, desc);
        cVal.put(COL_IN_AMO, amount);
//        cVal.put(COL_IN_DATE, date);
        db.update(TABLE_NAME_INCOME, cVal, "ID = ? ", new String[]{id});//Convenience method for updating rows in the database.
        return true;
    }

    public boolean updateIncomeTemp(String id, String temp) {
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        ContentValues cVal = new ContentValues();//ContentValues : Creates an empty set of values using the default initial size
        //put : Adds a value to the set.
        cVal.put(COL_IN_ID, id);
        cVal.put(COL_IN_TEMP, temp);
        db.update(TABLE_NAME_INCOME, cVal, "ID = ? ", new String[]{id});//Convenience method for updating rows in the database.
        return true;
    }

    public boolean updateExpense(String id, String desc, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        ContentValues cVal = new ContentValues();//ContentValues : Creates an empty set of values using the default initial size
        //put : Adds a value to the set.
        cVal.put(COL_EX_ID, id);
        cVal.put(COL_EX_DES, desc);
        cVal.put(COL_EX_AMO, amount);
//        cVal.put(COL_EX_DATE, date);
        db.update(TABLE_NAME_EXPENSES, cVal, "ID = ? ", new String[]{id});//Convenience method for updating rows in the database.
        return true;
    }

    public Integer deleteIncome(String id) {
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        return db.delete(TABLE_NAME_INCOME, "ID = ?", new String[] {id});//Convenience method for delete rows in the database.
    }

    public Integer deleteExpense(String id) {
        SQLiteDatabase db = this.getWritableDatabase();//Create and/or open a database that will be used for reading and writing.
        return db.delete(TABLE_NAME_EXPENSES, "ID = ?", new String[] {id});//Convenience method for delete rows in the database.
    }
}
