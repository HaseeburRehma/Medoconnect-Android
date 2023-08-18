package com.example.medoconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class wallet1 extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Button backArrowwallet,tButton,aButton,pButton,rButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet1);
        backArrowwallet= findViewById(R.id.backArrowwallet);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        pButton=findViewById(R.id. pButton);
        tButton=findViewById(R.id.tButton);
        aButton=findViewById(R.id.aButton);
        rButton= findViewById(R.id.rButton);
        bottomNavigationView.setItemIconTintList(null);

        backArrowwallet.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(wallet1.this, dashboard.class);
                startActivity(intent);
            }
        });




        pButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(wallet1.this, dashboard.class);
                startActivity(intent);
            }
        });

        tButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(wallet1.this,wallet.class);
                startActivity(intent);
            }
        });
        aButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(wallet1.this, wallet2.class);
                startActivity(intent);
            }
        });
        rButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(wallet1.this, dashboard.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_appointment) {
                startActivity(new Intent(getApplicationContext(), navigation.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_call) {
                startActivity(new Intent(getApplicationContext(), verify.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_med) {
                startActivity(new Intent(getApplicationContext(), signin.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(getApplicationContext(), signup.class));
                finish();
                return true;
            }

            return false;

        });


    }
}