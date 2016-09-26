package com.arianasp.advanceapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ariana on 9/25/2016.
 */

public class ExpensesDataBaseAdapter {

    static final String DATABASE_EXP = "expenses.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+"EXPENSES"+
            "( " +"ID"+" integer primary key autoincrement,"+ "STUFF  text,PRICE text); ";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  ExpensesDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_EXP, null, DATABASE_VERSION);
    }
    public  ExpensesDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String stuff,String price)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("STUFF", stuff);
        newValues.put("PRICE",price);

        // Insert the row into your table
        db.insert("EXPENSES", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String Stuff)
    {
        //String id=String.valueOf(ID);
        String where="STUFF=?";
        int numberOFEntriesDeleted= db.delete("EXPENSES", where, new String[]{Stuff}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String Stuff)
    {
        Cursor cursor=db.query("EXPENSES", null, " STUFF=?", new String[]{Stuff}, null, null, null);
        if(cursor.getCount()<1) // Stuff Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String price= cursor.getString(cursor.getColumnIndex("PRICE"));
        cursor.close();
        return price;
    }
    public void  updateEntry(String stuff,String price)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("STUFF", stuff);
        updatedValues.put("PRICE",price);

        String where="STUFF = ?";
        db.update("EXPENSES",updatedValues, where, new String[]{stuff});
    }
}
