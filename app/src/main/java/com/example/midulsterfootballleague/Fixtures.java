package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Division1Games.D1W1;
import Division2Games.D2W1;
import Division3Games.D3W1;
import Division4Games.D4W1;
import Division5Games.D5W1;
import LeagueTables.Division1;

public class Fixtures extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);


        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Mid Ulster Football League");


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(Fixtures.this, HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_table:
                        Intent intent2 = new Intent(Fixtures.this, Division1.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_club:
                        Intent intent3 = new Intent(Fixtures.this, Fixtures.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_inbox:
                        Intent intent4 = new Intent(Fixtures.this, Inbox.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

    public void division1 (View view){
        Intent intent = new Intent(Fixtures.this, D1W1.class);
        startActivity(intent);
    }

    public void division2 (View view){
        Intent intent = new Intent(Fixtures.this, D2W1.class);
        startActivity(intent);
    }

    public void division3 (View view){
        Intent intent = new Intent(Fixtures.this, D3W1.class);
        startActivity(intent);
    }

    public void division4 (View view){
        Intent intent = new Intent(Fixtures.this, D4W1.class);
        startActivity(intent);
    }

    public void division5 (View view){
        Intent intent = new Intent(Fixtures.this, D5W1.class);
        startActivity(intent);
    }
}
