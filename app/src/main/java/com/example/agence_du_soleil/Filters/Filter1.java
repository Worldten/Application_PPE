package com.example.agence_du_soleil.Filters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.agence_du_soleil.R;

public class Filter1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter1);
        Button buttonfiltre1 = findViewById(R.id.next1);
        buttonfiltre1.setOnClickListener(v -> {

            Intent intent_achat = new Intent(Filter1.this, Filter2.class);
            startActivity(intent_achat);


        });
    }
}