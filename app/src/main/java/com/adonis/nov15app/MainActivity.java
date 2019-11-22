package com.adonis.nov15app;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname, section, id;
    dbHelper helper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new dbHelper(this);
        id = findViewById(R.id.etid);
        fname = findViewById(R.id.etfname);
        lname = findViewById(R.id.etlname);
        section = findViewById(R.id.etsection);
        cursor = helper.getRecords();
    }

    public void addRecord (View view) {
        String first = fname.getText().toString();
        String last = lname.getText().toString();
        String sec = section.getText().toString();

        long isInserted = helper.insert(first, last, sec);

        if (isInserted == 1) {
            Toast.makeText(this, "not inserted", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "record inserted", Toast.LENGTH_LONG).show();
        }
    }

    public void moveFirst (View v) {
        cursor.moveToFirst();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }

    public void movePrevious (View v) {
        //cursor = helper.getRecords();
        cursor.moveToPrevious();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }

    public void moveNext (View v) {
        //cursor = helper.getRecords();
        cursor.moveToNext();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }

    public void moveLast (View v) {
        //cursor = helper.getRecords();
        cursor.moveToLast();
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }
}
