package com.example.easymean.android_study;

//import java.util.Calendar;

import java.io.Serializable;

public class Memo implements Serializable {
    private String text;
//    private String date;

    public Memo(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public String getDate(){
//        return date;
//    }

//    public void setDate(String date) {
//        this.date = date;
//    }


}

