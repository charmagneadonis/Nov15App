package com.adonis.nov15app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    String col2 = "Fname";
    String col3 = "Lname";
    String col4 = "Section";
    String table = "stud";

    public dbHelper(@Nullable Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE stud (ID INTEGER PRIMARY KEY AUTOINCREMENT, FName TEXT, LName TEXT, Section TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert (String fn, String ln, String sec) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2, fn);
        cv.put(col3, ln);
        cv.put(col4, sec);
        return db.insert(table, null, cv);
    }

    public Cursor getRecords() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectAll = "SELECT * FROM stud";
        return db.rawQuery(selectAll, null);
    }

}
