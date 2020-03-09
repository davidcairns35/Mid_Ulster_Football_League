package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    private View view;
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
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


    }

    public void register (View view){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}
