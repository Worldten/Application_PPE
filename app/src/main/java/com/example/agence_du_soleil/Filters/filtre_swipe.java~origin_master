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

import com.example.agence_du_soleil.R;
import com.example.agence_du_soleil.resultat_achat;

public class filtre_swipe extends Activity {

    private CheckBox appartement, chateau, maison, boutique, bureaux, local;
    private EditText ed1, ed2;
    private TextView text;
    private Dialog filtre1;
    private Dialog filtre2;
    private Dialog filtre3;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtre_swipe);
        filtre1 = new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar);
        filtre2 = new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar);
        filtre3 = new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar);
        filtre1.setContentView(R.layout.filtre1_achat);
        filtre2.setContentView(R.layout.filtre2_achat);
        filtre3.setContentView(R.layout.filtre3_achat);
        rg = (RadioGroup)  filtre2.findViewById(R.id.radio_recherche);
        addListenerOnButton();


        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }

    public void buttonclicked(View view){
        int radioButtonID = rg.getCheckedRadioButtonId();
        rb = (RadioButton) filtre2.findViewById(radioButtonID);

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
        appartement = (CheckBox) findViewById(R.id.checkb_appart);
        chateau = (CheckBox) filtre1.findViewById(R.id.checkb_chateau);
        maison = (CheckBox) filtre1.findViewById(R.id.checkb_maison);
        boutique = (CheckBox) filtre1.findViewById(R.id.checkb_boutique);
        bureaux = (CheckBox) filtre1.findViewById(R.id.checkb_bureaux);
        local = (CheckBox) filtre1.findViewById(R.id.checkb_loccomer);
        Button button = (Button) filtre3.findViewById(R.id.valider_recherche);
        ed1 = findViewById(R.id.surface_min);
        ed2 = findViewById(R.id.surface_max);

        button.setOnClickListener(v -> {
            StringBuffer result = new StringBuffer();
            if (appartement.isChecked()) {
                result.append("Appartement selectionné : ").append(appartement.isChecked());
            }
            if (chateau.isChecked()) {
                result.append("Chateau selectionné : ").append(chateau.isChecked());
            }
            if (maison.isChecked()) {
                result.append("\nMaison selectionnée :").append(maison.isChecked());
            }
            if (boutique.isChecked()) {
                result.append("\nBoutique selectionnée :").append(boutique.isChecked());
            }
            if (bureaux.isChecked()) {
                result.append("\nBureau selectionné: ").append(bureaux.isChecked());
            }
            if (local.isChecked()){
                result.append("\nLocal selectionné : ").append(local.isChecked());
            }
            Intent intent_resultat = new Intent(filtre_swipe.this, resultat_achat.class);
            startActivity(intent_resultat);
            text.setText(result);
        });
    }
}