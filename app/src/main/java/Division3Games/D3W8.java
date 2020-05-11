package Division3Games;

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

import Holder.ResultHolder;
import LeagueTables.Division1;
import Model.Results;

public class D3W8 extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture_result_display);


        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Week 8");

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        reference= database.getReference("results").child("division3").child("week8");


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(D3W8.this, HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_table:
                        Intent intent2 = new Intent(D3W8.this, Division1.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_club:
                        Intent intent3 = new Intent(D3W8.this, Fixtures.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_inbox:
                        Intent intent4 = new Intent(D3W8.this, Inbox.class);
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

        FirebaseRecyclerAdapter<Results, ResultHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Results, ResultHolder>(
                        Results.class,
                        R.layout.results,
                        ResultHolder.class,
                        reference) {
                    @Override
                    protected void populateViewHolder(ResultHolder resultHolder, Results results, int i) {
                        resultHolder.setView(getApplicationContext(), results.getHome(), results.getScore(),
                                results.getAway());
                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.result_30, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.week1:
                Intent intent1 = new Intent(D3W8.this, D3W1.class);
                startActivity(intent1);
                break;
            case R.id.week2:
                Intent intent2 = new Intent(D3W8.this, D3W2.class);
                startActivity(intent2);
                break;
            case R.id.week3:
                Intent intent3 = new Intent(D3W8.this, D3W3.class);
                startActivity(intent3);
                break;
            case R.id.week4:
                Intent intent4 = new Intent(D3W8.this, D3W4.class);
                startActivity(intent4);
                break;
            case R.id.week5:
                Intent intent5 = new Intent(D3W8.this, D3W5.class);
                startActivity(intent5);
                break;
            case R.id.week6:
                Intent intent6 = new Intent(D3W8.this, D3W6.class);
                startActivity(intent6);
                break;

            case R.id.week7:
                Intent intent7 = new Intent(D3W8.this, D3W7.class);
                startActivity(intent7);
                break;

            case R.id.week8:
                Intent intent8 = new Intent(D3W8.this, D3W8.class);
                startActivity(intent8);
                break;

            case R.id.week9:
                Intent intent9 = new Intent(D3W8.this, D3W9.class);
                startActivity(intent9);
                break;

            case R.id.week10:
                Intent intent10 = new Intent(D3W8.this, D3W10.class);
                startActivity(intent10);
                break;

            case R.id.week11:
                Intent intent11 = new Intent(D3W8.this, D3W11.class);
                startActivity(intent11);
                break;

            case R.id.week12:
                Intent intent12 = new Intent(D3W8.this, D3W12.class);
                startActivity(intent12);
                break;

            case R.id.week13:
                Intent intent13 = new Intent(D3W8.this, D3W13.class);
                startActivity(intent13);
                break;

            case R.id.week14:
                Intent intent14 = new Intent(D3W8.this, D3W14.class);
                startActivity(intent14);
                break;

            case R.id.week15:
                Intent intent15 = new Intent(D3W8.this, D3W15.class);
                startActivity(intent15);
                break;

            case R.id.week16:
                Intent intent16 = new Intent(D3W8.this, D3W16.class);
                startActivity(intent16);
                break;

            case R.id.week17:
                Intent intent17 = new Intent(D3W8.this, D3W17.class);
                startActivity(intent17);
                break;

            case R.id.week18:
                Intent intent18 = new Intent(D3W8.this, D3W18.class);
                startActivity(intent18);
                break;

            case R.id.week19:
                Intent intent19 = new Intent(D3W8.this, D3W19.class);
                startActivity(intent19);
                break;

            case R.id.week20:
                Intent intent20 = new Intent(D3W8.this, D3W20.class);
                startActivity(intent20);
                break;

            case R.id.week21:
                Intent intent21 = new Intent(D3W8.this, D3W21.class);
                startActivity(intent21);
                break;

            case R.id.week22:
                Intent intent22 = new Intent(D3W8.this, D3W22.class);
                startActivity(intent22);
                break;

            case R.id.week23:
                Intent intent23 = new Intent(D3W8.this, D3W23.class);
                startActivity(intent23);
                break;

            case R.id.week24:
                Intent intent24 = new Intent(D3W8.this, D3W24.class);
                startActivity(intent24);
                break;

            case R.id.week25:
                Intent intent25 = new Intent(D3W8.this, D3W25.class);
                startActivity(intent25);
                break;

            case R.id.week26:
                Intent intent26 = new Intent(D3W8.this, D3W26.class);
                startActivity(intent26);
                break;

            case R.id.week27:
                Intent intent27 = new Intent(D3W8.this, D3W27.class);
                startActivity(intent27);
                break;

            case R.id.week28:
                Intent intent28 = new Intent(D3W8.this, D3W28.class);
                startActivity(intent28);
                break;

        }
        return false;
    }
}
