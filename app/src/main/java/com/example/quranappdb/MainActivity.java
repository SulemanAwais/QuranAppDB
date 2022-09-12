package com.example.quranappdb;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.appcompat.widget.Toolbar;
//import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Button arabicBtn;
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer1);
        navigationView=findViewById(R.id.nav_view);
        arabicBtn=findViewById(R.id.button);
        arabicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ArabicVersion.class);
                startActivity(intent);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                                                                 @Override
                                                                 public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
                                                                 {
                                                                     switch (menuItem.getItemId())
                                                                     {
                                                                         case R.id.arabic:
                                                                             //Toast.makeText(getApplicationContext(),"Return is Clicked",Toast.LENGTH_LONG).show();
                                                                             Intent intent = new Intent(MainActivity.this, ArabicVersion.class);
                                                                             startActivity(intent);
                                                                             drawerLayout.closeDrawer(GravityCompat.START);
                                                                             break;

                                                                         case R.id.urdu:
                                                                             //Toast.makeText(getApplicationContext(),"Return is Clicked",Toast.LENGTH_LONG).show();
                                                                             Intent intent2 = new Intent(MainActivity.this, UrduVersion.class);
                                                                             startActivity(intent2);
                                                                             drawerLayout.closeDrawer(GravityCompat.START);
                                                                             break;

                                                                         case R.id.english:
                                                                             Intent intent3 = new Intent(MainActivity.this, _EnglishVersion.class);
                                                                             startActivity(intent3);
                                                                             drawerLayout.closeDrawer(GravityCompat.START);
                                                                             break;

                                                                     }

                                                                     return true;
                                                                 }
//        toolbar = findViewById(R.id.AppBar);
//        setSupportActionBar(toolbar);



//        toggle=new ActionBarDrawerToggle(this,d,toolbar,R.string.app_name,R.string.app_name);
//        d.addDrawerListener(toggle);
//        toggle.syncState();
    });}

//    void setupDrawer(){
//        setUpDrawerLayout();
//    }
//    void setUpDrawerLayout()
//    {
//        setSupportActionBar(AppBar);
//        a=ActionBarDrawerToggle(this,drawer1,R.string.app_name,R.string.app_name);
//   }

}
