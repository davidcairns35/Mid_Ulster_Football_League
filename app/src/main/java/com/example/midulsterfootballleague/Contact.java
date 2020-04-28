package com.example.midulsterfootballleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Holder.ContactHolder;
import Holder.HomePageHolder;
import Model.HomeGetSet;
import Model.User;

public class Contact extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contacts");

        recyclerView = findViewById(R.id.recyclerviewcontact);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        reference= database.getReference("Users");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(Contact.this, HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_table:
                        Intent intent2 = new Intent(Contact.this, Table.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_club:
                        Intent intent3 = new Intent(Contact.this, Fixtures.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_inbox:
                        Intent intent4 = new Intent(Contact.this, Inbox.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<User, ContactHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<User, ContactHolder>(
                        User.class,
                        R.layout.user_item,
                        ContactHolder.class,
                        reference) {
                    @Override
                    protected void populateViewHolder(ContactHolder contactHolder, User user, int i) {
                        contactHolder.setView(getApplicationContext(), user.getName());
                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}