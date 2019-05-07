package com.example.agence_du_soleil;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TextView;

public class filtre_swipe extends AppCompatActivity {

    TextView tx;
    Typeface custom_font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtre_swipe);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomPagerAdapter(this));



    }
}
