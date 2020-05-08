package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import LeagueTables.Division1;

public class Club extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(Club.this, HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_table:
                        Intent intent2 = new Intent(Club.this, Division1.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_club:
                        Intent intent3 = new Intent(Club.this, Club.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_inbox:
                        Intent intent4 = new Intent(Club.this, Inbox.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

    public void fixtures (View view){
        Intent intent = new Intent(Club.this, Fixtures.class);
        startActivity(intent);
    }

}
