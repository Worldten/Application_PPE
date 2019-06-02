package com.example.agence_du_soleil.Activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.agence_du_soleil.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListItemActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

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
    }

    @SuppressLint("StaticFieldLeak")
    private class GetItems extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ListItemActivity.this);pDialog.setMessage("Please wait...");
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

                    // looping through All Contacts
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject c = data.getJSONObject(i);

                        String type = c.getString("type_bien");
                        String nom = c.getString("nom_bien");
                        String ville = c.getString("ville_bien");
                        String address = c.getString("adresse1_bien");
                        double prix = c.getDouble("prix_bien");
                        int surface = c.getInt("surface_bien");
                        int piece = c.getInt("piece_bien");
                        int charge = c.getInt("charge_bien");
                        String cp = c.getString("cp_bien");

                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject("phone");
//                        String mobile = phone.getString("mobile");
//                        String home = phone.getString("home");
//                        String office = phone.getString("office");

                        HashMap<String, String> items = new HashMap<>();

                        items.put("type", type );
                        items.put("nom", nom);
                        items.put("adresse", address);
                        items.put("prix", String.valueOf(prix));
                        items.put("ville", ville);
                        items.put("surface", String.valueOf(surface));
                        items.put("piece", String.valueOf(piece));
                        items.put("charge", String.valueOf(charge));
                        items.put("cp", cp);

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
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    ListItemActivity.this, itemsList,
                    R.layout.activity_list_items, new String[]{"nom", "prix"}, new int[]{R.id.name_item});

            lv.setAdapter(adapter);
        }
    }
}