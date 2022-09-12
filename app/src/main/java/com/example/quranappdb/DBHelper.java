package com.example.quranappdb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public  class DBHelper extends SQLiteAssetHelper {
    public DBHelper(Context context) {
        super(context, "quran_database.db", null, 1);
    }

    public String[] getArabicNames()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT SurahNameU from tsurah",null);
        int i = 0;
        String[] data = new String[114];
        if (c.moveToFirst()) {

            do {
                data[i] = c.getString(0);
                i++;
            } while (c.moveToNext());
        }
        c.close();
        return data;
    }
    public ArrayList<String> gettingArabic(int _SuraID )
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String SuraIdString=Integer.toString(_SuraID);
        Cursor cursorCourses = db.rawQuery("SELECT Arabic_Text FROM tayah where  SuraID=?",new String[]{SuraIdString});

        ArrayList<String> data1=new ArrayList<>();
        if (cursorCourses.moveToFirst()) {

            do {
                data1.add(
                        (cursorCourses.getString(0))
                );
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data1;
    }

    //ENGLISH

    public String[] getEnglishName()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT SurahNameE from tsurah",null);
        int i = 0;
        String[] data = new String[114];
        if (c.moveToFirst()) {

            do {
                data[i] = c.getString(0);
                i++;
            } while (c.moveToNext());
        }
        c.close();
        return data;
    }
    public ArrayList<String> gettingEnglish(int _SuraID )
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String SuraIdString=Integer.toString(_SuraID);
        Cursor cursorCourses = db.rawQuery("SELECT Dr_Mohsin_Khan FROM tayah where  SuraID=?",new String[]{SuraIdString});

        ArrayList<String> data1=new ArrayList<>();
        if (cursorCourses.moveToFirst()) {

            do {
                data1.add(
                        (cursorCourses.getString(0))
                );
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data1;
    }


}