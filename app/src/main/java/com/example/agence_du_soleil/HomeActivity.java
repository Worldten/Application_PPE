package com.example.agence_du_soleil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton buttonAchat = findViewById(R.id.button_achat);
        buttonAchat.setOnClickListener(v -> {

            Intent intent_achat = new Intent(HomeActivity.this, Filter1.class);
            startActivity(intent_achat);
        });

        ImageButton buttonLouer = findViewById(R.id.button_louer);
        buttonLouer.setOnClickListener(v -> {

            Intent intent_louer = new Intent(HomeActivity.this, RentActivity.class);
            startActivity(intent_louer);
        });

        ImageButton buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(v -> {

            Intent intent_login = new Intent(HomeActivity.this, SignupActivity.class);
            startActivity(intent_login);
        });
    }
}
