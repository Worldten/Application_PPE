package com.example.agence_du_soleil;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Filter2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    float x1, x2, y1, y2;

    TextView tx;
    Typeface custom_font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter2);
        Button buttonfiltre1 = findViewById(R.id.next1);
        buttonfiltre1.setOnClickListener(v -> {

            Intent intent_achat = new Intent(Filter2.this, Filter3.class);
            startActivity(intent_achat);
        });

        tx = (TextView)findViewById(R.id.value_unit_symbol_min);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/agency-fb.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView)findViewById(R.id.value_unit_symbol_max);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/agency-fb.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView)findViewById(R.id.quelle_surface);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/agency-fb.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView)findViewById(R.id.nbr_piece);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/agency-fb.ttf");
        tx.setTypeface(custom_font);

        Spinner spinner = findViewById(R.id.spinner_pieces);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.pieces, R.layout.spinner_layout );
        adapter.setDropDownViewResource(R.layout.spinner_layout_list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

        public boolean onTouchEvent(MotionEvent touchevent){
            switch (touchevent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x1 = touchevent.getX();
                    y1 = touchevent.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = touchevent.getX();
                    y2 = touchevent.getY();
                    if (x1 < x2) {
                        Intent i = new Intent(Filter2.this, Filter1.class);
                        startActivity(i);
                    }
                    break;
            }
            return false;
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String txt = parent.getSelectedItem().toString();
        Toast.makeText(parent.getContext(), txt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
