package com.example.conornotes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    dbHelper NoteBook;

    ArrayList<Notes> noteList;
    ListView listView;
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        NoteBook = new dbHelper(this);
    }

    public void allNotes(){
        noteList = new ArrayList<>();
        final Cursor data = NoteBook.getAllNotes();
        final int notesNo = data.getCount();

        if (notesNo == 0){
            //If no data has been currently saved
            Toast.makeText(HomePage.this, "No Notes Saved!", Toast.LENGTH_LONG).show();
        } else {
            while(data.moveToNext()){
                notes = new Notes(data.getString(0),
                        data.getString(1), data.getString(2),
                        data.getString(3), data.getString(4));
                noteList.add(notes);
            }
            //List adapter
            notesList adapter = new notesList(this, R.layout.recycler_list, noteList);
            listView = findViewById(R.id.notesList);
            listView.setAdapter(adapter);
        }
    }
}
