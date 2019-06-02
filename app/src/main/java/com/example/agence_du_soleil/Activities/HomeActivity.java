package com.example.agence_du_soleil.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.example.agence_du_soleil.Filters.Filtre_swipe;
import com.example.agence_du_soleil.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton buttonAchat = findViewById(R.id.button_achat);
        buttonAchat.setOnClickListener(v -> {

            Intent intent_achat = new Intent(HomeActivity.this, DetailsActivity.class);
            startActivity(intent_achat);
        });

        ImageButton buttonLouer = findViewById(R.id.button_louer);
        buttonLouer.setOnClickListener(v -> {

           // Intent intent_louer = new Intent(HomeActivity.this, Filterjson.class);
           // startActivity(intent_louer);
        });

        ImageButton buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(v -> {

            Intent intent_login = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent_login);
        });
    }
}
