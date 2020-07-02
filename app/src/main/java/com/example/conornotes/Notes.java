package com.example.conornotes;

public class Notes {
    //Class to retrieve all note information for list view
    private String noteID;
    private String noteTitle;
    private String noteContent;
    private String noteDate;
    private String noteTime;

    public Notes(String id, String title, String content, String date, String time){
        //getting the note info
        noteID = id;
        noteTitle = title;
        noteContent = content;
        noteDate = date;
        noteTime = time;
    }

    public String getID() { return noteID; }
    public String getTitle() { return noteTitle; }
    public String getContent() { return noteContent; }
    public String getDate() { return noteDate; }
    public String getTime() { return noteTime; }
}
