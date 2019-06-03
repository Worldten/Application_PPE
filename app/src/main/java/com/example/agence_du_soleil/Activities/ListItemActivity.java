package com.example.agence_du_soleil.Activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.agence_du_soleil.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListItemActivity extends AppCompatActivity {

    private String TAG = ListItemActivity.class.getSimpleName();
    ListView listView;
    String TAG_IMG = "http://www.plaisancia.fr/typo3temp/_processed_/csm_maison-plaisancia-hericourt_f1763b14a9.jpg";
    private ProgressDialog pDialog;
    private ListView lv;

    ArrayList<HashMap<String, String>> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        itemsList = new ArrayList<>();

        lv = findViewById(R.id.lvMain);

        new GetItems().execute();

        listView = findViewById(R.id.listView3);


    }

    private class GetItems extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ListItemActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            // URL to get JSON
            String url = "https://api.thomaszimmermann.fr/biens";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray data = jsonObj.getJSONArray("data");

                    // looping through
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject c = data.getJSONObject(i);

                        String nom = c.getString("nom_bien");
                        String ville = c.getString("ville_bien");
                        String address = c.getString("adresse1_bien");
                        double prix = c.getDouble("prix_bien");
                        int surface = c.getInt("surface_bien");
                        int piece = c.getInt("piece_bien");
                        int charge = c.getInt("charge_bien");
                        String cp = c.getString("cp_bien");
                        String image = c.getString("lien_image");


                        HashMap<String, String> items = new HashMap<>();

                        items.put("nom", nom);
                        items.put("adresse", address);
                        items.put("prix", String.valueOf(prix));
                        items.put("ville", ville);
                        items.put("surface", String.valueOf(surface));
                        items.put("piece", String.valueOf(piece));
                        items.put("charge", String.valueOf(charge));
                        items.put("cp", cp);
                        items.put("image", image);

                        itemsList.add(items);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(() -> Toast.makeText(getApplicationContext(),
                            "Json parsing error: " + e.getMessage(),
                            Toast.LENGTH_LONG)
                            .show());
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(() -> Toast.makeText(getApplicationContext(),
                        "Couldn't get json from server. Check LogCat for possible errors!",
                        Toast.LENGTH_LONG)
                        .show());
            }


            return null;
        }



        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    ListItemActivity.this, itemsList,
                    R.layout.listview, new String[]{"image", "nom", "prix", "surface", "piece", "ville", "charge"}, new int[]{R.id.img, R.id.nom_bien, R.id.prix_bien, R.id.surface_bien, R.id.ville_bien, R.id.charge_bien, R.id.piece_bien});


//            ImageView ivBasicImage = findViewById(R.id.img);
//            Picasso.with(getApplicationContext()).load(image).into(ivBasicImage);
            lv.setAdapter(adapter);

        }
    }
}