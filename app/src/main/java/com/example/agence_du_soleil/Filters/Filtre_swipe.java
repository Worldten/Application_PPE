package com.example.agence_du_soleil.Filters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.agence_du_soleil.Activities.ListItemActivity;
import com.example.agence_du_soleil.R;
import com.example.agence_du_soleil.resultat_achat;

public class Filtre_swipe extends Activity {


    private EditText ed1, ed2;
    private TextView text;
    private Dialog filtre2;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtre_swipe);

        rg = findViewById(R.id.radio_recherche);
        addListenerOnButton();


//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(new CustomPagerAdapter(this));
    }

    public void buttonclicked(View view){
        int radioButtonID = rg.getCheckedRadioButtonId();
        rb = filtre2.findViewById(radioButtonID);

        boolean checked = ((RadioButton) view).isChecked();
        switch (radioButtonID){
            case R.id.radio_piece1:
                if (checked)
                    break;
            case R.id.radio_piece2:
                if (checked)
                    break;
            case R.id.radio_piece3:
                if (checked)
                    break;
            case R.id.radio_piece4:
                if (checked)
                    break;
            case R.id.radio_piece5etplus:
                if (checked)
                    break;
        }
    }


    public void addListenerOnButton() {

        Button button = findViewById(R.id.validate);
        ed1 = findViewById(R.id.surface_min);
        ed2 = findViewById(R.id.surface_max);

        button.setOnClickListener(v -> {

            Intent intent = new Intent(Filtre_swipe.this, ListItemActivity.class);
            startActivity(intent);

        });
    }
}