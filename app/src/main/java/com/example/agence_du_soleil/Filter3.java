package com.example.agence_du_soleil;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Filter3 extends AppCompatActivity {

    TextView tx;
    Typeface custom_font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter3);
        Button buttonfiltre1 = findViewById(R.id.next1);
        buttonfiltre1.setOnClickListener(v -> {

            Intent intent_achat = new Intent(Filter3.this, resultat_achat.class);
            startActivity(intent_achat);
        });

        tx = (TextView)findViewById(R.id.title_budget);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/agency-fb.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView)findViewById(R.id.budget_max);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/agency-fb.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView)findViewById(R.id.euros);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/agency-fb.ttf");
        tx.setTypeface(custom_font);
    }

}
