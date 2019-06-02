package com.example.agence_du_soleil.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.agence_du_soleil.R;

public class FormulaireActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);
        rg = (RadioGroup)  findViewById(R.id.radio_formulaire);
    }

    public void buttonclicked(View view){
        int radioButtonID = rg.getCheckedRadioButtonId();
            rb = (RadioButton) findViewById(radioButtonID);

        boolean checked = ((RadioButton) view).isChecked();
        switch (radioButtonID){
            case R.id.radio_appartement:
                if (checked)
                    break;
            case R.id.radio_boutique:
                if (checked)
                    break;
            case R.id.radio_bureaux:
                if (checked)
                    break;
            case R.id.radio_chateau:
                if (checked)
                    break;
            case R.id.radio_loc_commercial:
                if (checked)
                    break;
            case R.id.radio_maison:
                if (checked)
                    break;
            case R.id.radio_terrain:
                if (checked)
                    break;
        }
    }
}
