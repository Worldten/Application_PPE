package com.example.agence_du_soleil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class Filter2 extends AppCompatActivity {

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter2);
    }



        /**public boolean onTouchEvent(MotionEvent touchevent){
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
        }**/

}
