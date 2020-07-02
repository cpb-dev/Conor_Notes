package com.example.conornotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class notesList extends ArrayAdapter<Notes> {
    private LayoutInflater mInflater;
    private ArrayList<Notes> notesList;
    private int mViewResourceId;

    public notesList(Context context, int textViewResourceId, ArrayList<Notes> notesList) {
        super(context, textViewResourceId, notesList);
        this.notesList = notesList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = mInflater.inflate(mViewResourceId, null);
        Notes notes = notesList.get(position);

        if(notes != null){
            TextView noteID = (TextView) convertView.findViewById(R.id.nID);
            TextView noteTitle = (TextView) convertView.findViewById(R.id.nTitle);
            TextView noteContent = (TextView) convertView.findViewById(R.id.nContent);
            TextView noteDate = (TextView) convertView.findViewById(R.id.nDate);
            TextView noteTime = (TextView) convertView.findViewById(R.id.nTime);

            if(noteID != null){
                noteID.setText((notes.getID()));
            }
            if(noteTitle != null){
                noteTitle.setText((notes.getTitle()));
            }
            if(noteContent != null){
                noteContent.setText((notes.getContent()));
            }
            if(noteDate != null){
                noteDate.setText((notes.getDate()));
            }
            if(noteTime != null){
                noteTime.setText((notes.getTime()));
            }
        }

        return convertView;
    }
}

