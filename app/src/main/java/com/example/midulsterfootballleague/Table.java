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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class Table extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<League> leagues = new ArrayList<>();
    Context c;
    FirebaseHelper helper;
    EditText Position, Team, Played, Points, Goals;

    public class FirebaseHelper {
        DatabaseReference databaseReference;
        ListView listView;
        ArrayList<League> leagues = new ArrayList<>();
        Table c;


        public FirebaseHelper(DatabaseReference databaseReference, Table context, ListView listView) {
            this.databaseReference = databaseReference;
            this.c = context;
            this.listView = listView;
            this.retrieve();
        }

        public ArrayList<League> retrieve() {
            databaseReference.child("Division 1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    leagues.clear();
                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            League league = ds.getValue(League.class);
                            leagues.add(league);
                        }
                        CustomAdapter adapter = new CustomAdapter(c, leagues);
                        listView.setAdapter(adapter);

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                listView.smoothScrollToPosition(leagues.size());
                            }
                        });
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("mTag", databaseError.getMessage());
                    Toast.makeText(Table.this, "ERROR " + databaseError.getMessage(), Toast.LENGTH_LONG).show();

                }
            });

            return leagues;
        }

    }

    class CustomAdapter extends BaseAdapter {
        Table c;
        ArrayList<League> leagues;

        public CustomAdapter(Table c, ArrayList<League> leagues) {
            this.c = c;
            this.leagues = leagues;
        }

        @Override
        public int getCount() {
            return leagues.size();
        }

        @Override
        public Object getItem(int position) {
            return leagues.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(c).inflate(R.layout.league_model, parent, false);
            }

            TextView Position = convertView.findViewById(R.id.Position);
            TextView Team = convertView.findViewById(R.id.TeamName);
            TextView Played = convertView.findViewById(R.id.Played);
            TextView Goals = convertView.findViewById(R.id.Goals);
            TextView Points = convertView.findViewById(R.id.Points);

            final League s = (League) this.getItem(position);

            Position.setText(s.getPosition());
            Team.setText(s.getTeamName());
            Played.setText(s.getPlayed());
            Points.setText(s.getPoints());
            Goals.setText(s.getGoals());

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Division 1");

        listView = (ListView) findViewById(R.id.listViewTxt);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(databaseReference, this, listView);




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