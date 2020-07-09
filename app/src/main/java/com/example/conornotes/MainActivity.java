package com.example.conornotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        //Action bar
        getSupportActionBar().setTitle("New Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Declaring user input positions
        etTitle = (EditText) findViewById(R.id.noteTitle);
        etContent = (EditText) findViewById(R.id.mainNote);
        Date = fDate.format(present);
        Time = fTime.format(present);

        //Declaring button
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();
                String date = Date.toString();
                String time = Time.toString();

                if(title.length() != 0 && content.length() != 0){

                    //Note validations
                    if(title.length() == 0){
                        Toast.makeText(MainActivity.this, "Note Needs Title!", Toast.LENGTH_LONG).show();
                    } else if(content.length() == 0){
                        Toast.makeText(MainActivity.this, "Note Needs Content", Toast.LENGTH_LONG).show();
                    }

                    else{
                        //Actually saving the note
                        addNote(date, time, title, content);

                        etTitle.setText("");
                        etContent.setText("");

                        goHome();
                    }
                } else {
                    //If there is no content a message shall be displayed
                    Toast.makeText(MainActivity.this, "Nothing Entered!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void addNote(String date, String time, String title, String content){
        //Method to check the notes data is present
        boolean insertNote = Notebook.addNote(date, time, title, content);

        //Messages for the user
        if(insertNote == true){
            Toast.makeText(this, "Note Saved", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, "Couldn't Save!", Toast.LENGTH_LONG).show();
        }
    }

    public void goHome(){
        /*
        Method to be launched when a note has been saved
        To take user back to the homepage
        */
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
