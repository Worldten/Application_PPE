package com.example.agence_du_soleil.Filters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.agence_du_soleil.Activities.ListItemActivity;
import com.example.agence_du_soleil.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Filtre_swipe extends Activity {

     EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtre_swipe);

        Button button1 = findViewById(R.id.validate);
        ed1 = findViewById(R.id.surface_min);
        ed2 = findViewById(R.id.surface_max);
        ed3 = findViewById(R.id.budget_max);

        button1.setOnClickListener(v -> {
            Log.v("Surface min= ", ed1.getText().toString());
            Log.v("Surface max= ", ed2.getText().toString());
            Log.v("Budget max= ", ed3.getText().toString());
            String surfacemin = ed1.getText().toString();
            String surfacemax = ed2.getText().toString();
            String budgetmax = ed3.getText().toString();

            Intent intent = new Intent(this, ListItemActivity.class);
            startActivity(intent);

//            try {
//                URL url = new URL("https://api.thomaszimmermann.fr/bien_filtre?surfacemin="+surfacemin+"&surfacemax="+surfacemax+"&budget="+budgetmax);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//                con.setRequestMethod("GET");
//
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(con.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null){
//                    response.append(inputLine);
//                }
//                in.close();
//
//                JSONObject jsonObject = new JSONObject(response.toString());
//                JSONArray jsonArray = jsonObject.getJSONArray("data");
//
//
//
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }


        });


    }
}