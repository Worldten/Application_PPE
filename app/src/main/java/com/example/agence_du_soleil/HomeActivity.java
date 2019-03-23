package com.example.agence_du_soleil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Buy
        Button buttonAchat = findViewById(R.id.button_achat);
        buttonAchat.setOnClickListener(v -> {

            Intent intent_achat = new Intent(HomeActivity.this, BuyingActivity.class);
            startActivity(intent_achat);
        });
        // Rent
        Button buttonLouer = findViewById(R.id.button_location);
        buttonLouer.setOnClickListener(v -> {

            Intent intent_louer = new Intent(HomeActivity.this, LocationActivity.class);
            startActivity(intent_louer);
        });
        // Sell
        Button buttonVendre = findViewById(R.id.button_vente);
        buttonVendre.setOnClickListener(v -> {

            Intent intent_vente = new Intent(HomeActivity.this, SellActivity.class);
            startActivity(intent_vente);
        });
    }
}
