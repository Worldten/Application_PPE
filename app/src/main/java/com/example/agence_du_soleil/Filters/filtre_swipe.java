package com.example.agence_du_soleil.Filters;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.agence_du_soleil.Filters.CustomPagerAdapter;
import com.example.agence_du_soleil.R;

public class filtre_swipe extends Activity {

    private CheckBox appartement, chateau, maison, boutique, bureaux, local;
    private Button button;
    private EditText ed1, ed2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtre_swipe);
        addListenerOnButton();

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }

    public void addListenerOnButton() {

        appartement = findViewById(R.id.checkb_appart);
        chateau = findViewById(R.id.checkb_chateau);
        maison = findViewById(R.id.checkb_maison);
        boutique = findViewById(R.id.checkb_boutiue);
        bureaux = findViewById(R.id.checkb_bureaux);
        local = findViewById(R.id.checkb_loccomer);
        // button = (Button) findViewById(R.id.go);
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
                result.append("\niMaison selectionnée :").append(maison.isChecked());
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
            text.setText(result);
        });
    }
}