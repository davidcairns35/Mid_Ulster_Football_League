package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText Email, Name, Password, ConfirmPassword;

    private androidx.appcompat.widget.Toolbar toolbar;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");


        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.confirmPassword);

        firebaseAuth = FirebaseAuth.getInstance();

        findViewById(R.id.register).setOnClickListener(this);
    }

        private void registerUser () {
            final String name = Name.getText().toString().trim();
            final String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();
            String confirmPassword = ConfirmPassword.getText().toString().trim();


            if (TextUtils.isEmpty(email)) {
                Email.setError("Please enter a valid email");
                return;
            }

            if (name.isEmpty()) {
                Name.setError("Please enter Your Full Name");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Password.setError("Please enter a valid password");
                return;
            }

            if (password.length() < 8) {
                Password.setError("A password must contain at least 8 characters");
                return;
            }

            if (!password.equals(confirmPassword)) {
                ConfirmPassword.setError("Passwords do not match");
                return;
            }

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        User user = new User(
                                name,
                                email
                        );

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(Register.this, "Failed to register user", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    } else {
                        Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                registerUser();
                break;
        }
        Intent intent = new Intent(Register.this, HomePage.class);
        startActivity(intent);
    }
}