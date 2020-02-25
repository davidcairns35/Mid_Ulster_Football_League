package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    private View view;
    private DatabaseReference mDatabase;
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabase = FirebaseDatabase.getInstance() .getReference("user");
        login = findViewById(R.id.Login);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                login(view);

            }
        });
    }

    public void login (View view){

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();
                    try {
                        //Read the values
                        String eString = String.valueOf(dataMap.get("username"));
                        String pString = String.valueOf(dataMap.get("password"));
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    } catch (ClassCastException err) {
                        Toast.makeText(getApplicationContext(), "Username or password is incorrect or does not match", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void register (View view){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}
