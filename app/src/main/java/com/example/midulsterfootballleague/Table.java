package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;
import java.util.List;

public class Table extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Division 1");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_leagues);
        new FirebaseDatabaseHelper().printTable(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<League> leagues, List<String> keys) {
                new RecyclerView_Config().setConfig(recyclerView,Table.this, leagues, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(Table.this, HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_table:
                        Intent intent2 = new Intent(Table.this, Table.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_club:
                        Intent intent3 = new Intent(Table.this, Club.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_inbox:
                        Intent intent4 = new Intent(Table.this, Inbox.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

}