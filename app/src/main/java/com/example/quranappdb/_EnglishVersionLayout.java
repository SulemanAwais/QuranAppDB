package com.example.quranappdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class _EnglishVersionLayout extends AppCompatActivity {

    String pos;
    DBHelper helper;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_version_layout);
        helper = new DBHelper(this);
        Intent intent1 = getIntent();
        pos = intent1.getStringExtra("positionIndex");
        int _Pos=Integer.valueOf(pos);
        _Pos=_Pos+1;
        ArrayList<String> data1=helper.gettingEnglish(_Pos);
        listView = findViewById(R.id.EnglishAyatlist);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data1);
        listView.setAdapter(arrayAdapter1);
    }  {
    }
}