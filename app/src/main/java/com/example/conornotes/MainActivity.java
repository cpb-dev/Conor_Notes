package com.example.conornotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    dbHelper Notebook;

    Button btnSave;
    EditText etTitle, etContent;

    //Date and Time metadata
    Date present = new Date();
    SimpleDateFormat
            fDate = new SimpleDateFormat("dd/MM/yyyy"),
            fTime = new SimpleDateFormat("HH:mm");
    String Date, Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notebook = new dbHelper(this); //Linking the DB to the page

        //Declaring user input positions
        etTitle = (EditText) findViewById(R.id.noteTitle);
        etContent = (EditText) findViewById(R.id.mainNote);
        btnSave = (Button) findViewById(R.id.btnSave);
        Date = fDate.format(present);
        Time = fTime.format(present);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
