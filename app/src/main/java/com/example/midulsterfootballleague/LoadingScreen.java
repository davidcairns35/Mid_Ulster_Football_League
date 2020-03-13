package com.example.midulsterfootballleague;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        Thread myThread = new Thread(){
            @Override
            public void run() {
             try {
                 sleep(3000);
                 Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                 startActivity(intent);
                 finish();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }
    };
        myThread.start();
    }
}
