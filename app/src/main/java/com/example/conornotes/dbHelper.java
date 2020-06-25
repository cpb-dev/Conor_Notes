package com.example.conornotes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    //Database info
    public static final String DB_Name = "Notebook";
    public static final String TABLE_NAME = "Notes";

    public static final String COL1 = "ID";
    public static final String COL2 = "Title";
    public static final String COL3 = "Content";
    public static final String COL4 = "Date";
    public static final String COL5 = "Time";

    public dbHelper(Context context){
        super(context, DB_Name, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Title TEXT, Content TEXT, Date DATE, Time TIMESTAMP)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
