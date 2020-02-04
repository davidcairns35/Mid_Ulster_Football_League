package com.example.midulsterfootballleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private View view;
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

    public void register (View view){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}
