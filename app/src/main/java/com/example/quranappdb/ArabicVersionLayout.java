package com.example.quranappdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
public class ArabicVersionLayout extends AppCompatActivity {
    String pos;
    DBHelper helper;
    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arabic_activity);
//        db = new DBHelper(this);
        helper = new DBHelper(this);
        Intent intent1 = getIntent();
        pos = intent1.getStringExtra("positionIndex");
        int _Pos=Integer.valueOf(pos);
        _Pos=_Pos+1;
        ArrayList<String> data1=helper.gettingArabic(_Pos);
        listView1 = findViewById(R.id.list2);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data1);
        listView1.setAdapter(arrayAdapter1);
    }  {
}}
