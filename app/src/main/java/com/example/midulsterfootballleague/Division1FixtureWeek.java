package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

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

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnWeek1:
                Intent intent = new Intent(Division1FixtureWeek.this, D1W1.class);
                startActivity(intent);
                break;

            case R.id.btnWeek2:
                Intent intent2 = new Intent(Division1FixtureWeek.this, D1W2.class);
                startActivity(intent2);
                break;

            case R.id.btnWeek3:
                Intent intent3 = new Intent(Division1FixtureWeek.this, D1W3.class);
                startActivity(intent3);
                break;

            case R.id.btnWeek4:
                Intent intent4 = new Intent(Division1FixtureWeek.this, D1W4.class);
                startActivity(intent4);
                break;

            case R.id.btnWeek5:
                Intent intent5 = new Intent(Division1FixtureWeek.this, D1W5.class);
                startActivity(intent5);
                break;

            case R.id.btnWeek6:
                Intent intent6 = new Intent(Division1FixtureWeek.this, D1W6.class);
                startActivity(intent6);
                break;

            case R.id.btnWeek7:
                Intent intent7 = new Intent(Division1FixtureWeek.this, D1W7.class);
                startActivity(intent7);
                break;

            case R.id.btnWeek8:
                Intent intent8 = new Intent(Division1FixtureWeek.this, D1W8.class);
                startActivity(intent8);
                break;

            case R.id.btnWeek9:
                Intent intent9 = new Intent(Division1FixtureWeek.this, D1W9.class);
                startActivity(intent9);
                break;

            case R.id.btnWeek10:
                Intent intent10 = new Intent(Division1FixtureWeek.this, D1W10.class);
                startActivity(intent10);
                break;

            case R.id.btnWeek11:
                Intent intent11 = new Intent(Division1FixtureWeek.this, D1W11.class);
                startActivity(intent11);
                break;

            case R.id.btnWeek12:
                Intent intent12 = new Intent(Division1FixtureWeek.this, D1W12.class);
                startActivity(intent12);
                break;

            case R.id.btnWeek13:
                Intent intent13 = new Intent(Division1FixtureWeek.this, D1W13.class);
                startActivity(intent13);
                break;

            case R.id.btnWeek14:
                Intent intent14 = new Intent(Division1FixtureWeek.this, D1W14.class);
                startActivity(intent14);
                break;

            case R.id.btnWeek15:
                Intent intent15 = new Intent(Division1FixtureWeek.this, D1W15.class);
                startActivity(intent15);
                break;

            case R.id.btnWeek16:
                Intent intent16 = new Intent(Division1FixtureWeek.this, D1W16.class);
                startActivity(intent16);
                break;

            case R.id.btnWeek17:
                Intent intent17 = new Intent(Division1FixtureWeek.this, D1W17.class);
                startActivity(intent17);
                break;

            case R.id.btnWeek18:
                Intent intent18 = new Intent(Division1FixtureWeek.this, D1W18.class);
                startActivity(intent18);
                break;

            case R.id.btnWeek19:
                Intent intent19 = new Intent(Division1FixtureWeek.this, D1W19.class);
                startActivity(intent19);
                break;

            case R.id.btnWeek20:
                Intent intent20 = new Intent(Division1FixtureWeek.this, D1W20.class);
                startActivity(intent20);
                break;

            case R.id.btnWeek21:
                Intent intent21 = new Intent(Division1FixtureWeek.this, D1W21.class);
                startActivity(intent21);
                break;

            case R.id.btnWeek22:
                Intent intent22 = new Intent(Division1FixtureWeek.this, D1W22.class);
                startActivity(intent22);
                break;

            case R.id.btnWeek23:
                Intent intent23 = new Intent(Division1FixtureWeek.this, D1W23.class);
                startActivity(intent23);
                break;

            case R.id.btnWeek24:
                Intent intent24 = new Intent(Division1FixtureWeek.this, D1W24.class);
                startActivity(intent24);
                break;

            case R.id.btnWeek25:
                Intent intent25 = new Intent(Division1FixtureWeek.this, D1W25.class);
                startActivity(intent25);
                break;

            case R.id.btnWeek26:
                Intent intent26 = new Intent(Division1FixtureWeek.this, D1W26.class);
                startActivity(intent26);
                break;

            case R.id.btnWeek27:
                Intent intent27 = new Intent(Division1FixtureWeek.this, D1W27.class);
                startActivity(intent27);
                break;

            case R.id.btnWeek28:
                Intent intent28 = new Intent(Division1FixtureWeek.this, D1W28.class);
                startActivity(intent28);
                break;

            case R.id.btnWeek29:
                Intent intent29 = new Intent(Division1FixtureWeek.this, D1W29.class);
                startActivity(intent29);
                break;

            case R.id.btnWeek30:
                Intent intent30 = new Intent(Division1FixtureWeek.this, D1W30.class);
                startActivity(intent30);
                break;
        }
    }
}
