package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    private int time_loading = 1000; //1000 = 1 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // setelah loading menuju dashboard
                Intent Home = new Intent(splash.this, MainActivity.class);
                startActivity(Home);
                finish();
            }
        },time_loading);
    }
}
