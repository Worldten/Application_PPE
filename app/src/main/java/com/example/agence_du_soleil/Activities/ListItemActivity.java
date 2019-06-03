package com.example.agence_du_soleil.Activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agence_du_soleil.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

//import com.bumptech.glide.Glide;

public class ListItemActivity extends AppCompatActivity {

    private static final String LOG_TAG = "Merde";
    private String TAG = ListItemActivity.class.getSimpleName();
    ListView listView;
    ArrayList<Product> itemsList;
    String TAG_IMG = "http://www.plaisancia.fr/typo3temp/_processed_/csm_maison-plaisancia-hericourt_f1763b14a9.jpg";
    private ProgressDialog pDialog;
    private ListView lv;


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
                        String classe_energ = c.getString("class_energetique_bien");


                        HashMap<String, String> items = new HashMap<>();

                        itemsList.add(new Product(
                                image,nom,prix,ville,address,surface,piece,charge,cp,classe_energ
                        ));
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

            Log.i(LOG_TAG,"Image url is: "+itemsList.toString());

            CustomListAdapter adapter = new CustomListAdapter(getApplicationContext(), R.layout.listview, itemsList);
            lv.setAdapter(adapter);

        }
    }
}