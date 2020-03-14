package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {

    private EditText Email, Name, Password, ConfirmPassword;

    private Button register;

    private androidx.appcompat.widget.Toolbar toolbar;

    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Intent intent = new Intent(Register.this, HomePage.class);
                startActivity(intent);
                finish();
                return;
            }
        };

        Email = findViewById(R.id.Email);
        Name = findViewById(R.id.Name);
        Password = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.confirmPassword);

        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword = ConfirmPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Email.setError("Please enter a valid email");
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    Name.setError("Please enter Your full name");
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
                            String user_id = firebaseAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                            String name = Name.getText().toString();

                            Map newPost = new HashMap();
                            newPost.put("name", name);
                            current_user_db.setValue(newPost);

                            Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(Register.this, HomePage.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register.this, "Failed to register user", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}