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


public class Register extends AppCompatActivity {
    EditText Email;
    EditText username;
    EditText Password;
    EditText ConfirmPassword;
    Button register;
    private androidx.appcompat.widget.Toolbar toolbar;

    FirebaseAuth firebaseAuth;
    //private DatabaseReference mDatabase;
    //private ProgressBar progressBar;

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
        username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.confirmPassword);
        register = findViewById(R.id.register);

        firebaseAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword = ConfirmPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Email.setError("Please enter a valid email");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Password.setError("Please enter a valid password");
                    return;
                }

                if (password.length() < 8){
                    Password.setError("A password must contain at least 8 characters");
                    return;
                }

                if (!password.equals(confirmPassword)){
                    ConfirmPassword.setError("Passwords do not match");
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password) .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
