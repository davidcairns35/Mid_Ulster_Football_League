package LeagueTables;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midulsterfootballleague.Fixtures;
import com.example.midulsterfootballleague.HomePage;
import com.example.midulsterfootballleague.Inbox;
import com.example.midulsterfootballleague.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Holder.Holder;
import Model.League;


public class Division5 extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;


    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Division 5");

        recyclerView = findViewById(R.id.recyclerviewhomepage);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        reference= database.getReference("LeagueTables").child("Division5");


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(LeagueTables.Division5.this, HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_table:
                        Intent intent2 = new Intent(LeagueTables.Division5.this, LeagueTables.Division5.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_club:
                        Intent intent3 = new Intent(LeagueTables.Division5.this, Fixtures.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_inbox:
                        Intent intent4 = new Intent(LeagueTables.Division5.this, Inbox.class);
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

        FirebaseRecyclerAdapter<League, Holder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<League, Holder>(
                        League.class,
                        R.layout.data,
                        Holder.class,
                        reference.orderByChild("Position")) {
                    @Override
                    protected void populateViewHolder(Holder holder, League league, int i) {
                        holder.setView(getApplicationContext(), league.getPosition(), league.getTeamName(),
                                league.getPlayed(), league.getGoals(), league.getPoints());
                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.league_table_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.division1:
                Intent intent = new Intent(Division5.this, Division1.class);
                startActivity(intent);
                break;
            case R.id.division2:
                Intent intent2 = new Intent(Division5.this, Division2.class);
                startActivity(intent2);
                break;
            case R.id.division3:
                Intent intent3 = new Intent(Division5.this, Division3.class);
                startActivity(intent3);
                break;
            case R.id.division4:
                Intent intent4 = new Intent(Division5.this, Division4.class);
                startActivity(intent4);
                break;
            case R.id.division5:
                Intent intent5 = new Intent(Division5.this, Division5.class);
                startActivity(intent5);
                break;

        }
        return false;
    }
}
