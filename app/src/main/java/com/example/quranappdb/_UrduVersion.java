package com.example.quranappdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class _UrduVersion extends AppCompatActivity {
    ListView listView;
    DBHelper helper;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_version);

        listView = findViewById(R.id.EnglishNamelist);
        helper = new DBHelper(this);
        String[] suraID=new String[114];

        suraID = helper.getUrduName();

        ArrayList<String> data= new ArrayList<>();

        for (String item: suraID)
        {
            data.add(item);
        }
//        listView = findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String text = "You Clicked on Position " + i;
            pos=i;
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(_UrduVersion.this, _UrduVersionLayout.class);
            intent.putExtra("positionIndex",String.valueOf(pos));
            startActivity(intent);

        });
    }
}