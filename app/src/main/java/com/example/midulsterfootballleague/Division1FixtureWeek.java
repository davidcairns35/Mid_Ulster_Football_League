package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Division1FixtureWeek extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division1_fixture_week);


        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mid Ulster Football League");


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(Division1FixtureWeek.this, HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_table:
                        Intent intent2 = new Intent(Division1FixtureWeek.this, Table.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_club:
                        Intent intent3 = new Intent(Division1FixtureWeek.this, Fixtures.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_inbox:
                        Intent intent4 = new Intent(Division1FixtureWeek.this, Inbox.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

    public void week1 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week2 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week3 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week4 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week5 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week6 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week7 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week8 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week9 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week10 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week11 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week12 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week13 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week14 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week15 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week16 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week17 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week18 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week19 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week20 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week21 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }public void week22 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week23 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week24 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week25 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week26 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week27 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week28 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week29 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
    public void week30 (View view){
        Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
        startActivity(intent);
    }
}
