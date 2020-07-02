package com.example.conornotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    //Database info
    public static final String DB_Name = "Notebook";
    public static final String TABLE_NAME = "Notes";
    public static final String COL1 = "ID"; //Doesn't get called as it is automatically created
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

    public boolean addNote(String Date, String Time, String Title, String Content){
        /*
        Preparing the database for setup
        Making it editable and giving it content values
         */
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Values
        cv.put(COL2, Title);
        cv.put(COL3, Content);
        cv.put(COL4, Date);
        cv.put(COL5, Time);

        //Checking the data being inputted
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllNotes(){
        //Query to retrieve all notes made in database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public Cursor getNote(String id){
        //Retrieving a note based on ID
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id, null);
        return data;
    }

    public boolean amendNote(String id, String title, String content){
        /*
        Method for amending the notes, based on their current state
        Date will remain the same as it is related to when the note was initially made
        */
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, id);
        cv.put(COL2, title);
        cv.put(COL3, content);
        db.update(TABLE_NAME, cv, "ID = ?", new String[] {id});
        return true;
    }

    public void deleteNote(String id){
        //Retrieving and deleting a note based on ID
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE ID = " + id;
        db.execSQL(query);
    }
}
