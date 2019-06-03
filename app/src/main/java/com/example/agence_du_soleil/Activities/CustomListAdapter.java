package com.example.agence_du_soleil.Activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agence_du_soleil.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by quocnguyen on 03/08/2016.
 */
public class CustomListAdapter extends ArrayAdapter<Product> {

    private static final String LOG_TAG = "Corentin";
    ArrayList<Product> products;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null, true);

        }
        Product product = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.imageViewProduct);
        Picasso.with(getContext()).load(product.getImage()).into(imageView);
        Log.i(LOG_TAG,"Image url is: "+product.getImage());

        TextView txtName = convertView.findViewById(R.id.txtName);
        txtName.setText(product.getName());
        Log.i(LOG_TAG,"Name is: "+product.getName());

        TextView txtPrice = convertView.findViewById(R.id.txtPrice);
        txtPrice.setText(product.getPrice());
        Log.i(LOG_TAG,"Price is: "+product.getPrice());

        TextView txtClass = convertView.findViewById(R.id.txtclass);
        txtClass.setText(product.getClasse());
        txtClass.setBackgroundColor(Color.parseColor(product.getCouleur(product.getClasse())));
        Log.i(LOG_TAG,"Classe is: "+product.getPrice());
        Log.i(LOG_TAG,"Couleur is: "+product.getCouleur(product.getClasse()));


        return convertView;
    }
}