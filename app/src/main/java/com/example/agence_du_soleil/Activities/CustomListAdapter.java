package com.example.agence_du_soleil.Activities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
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

    ArrayList<Product> products;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview, null, true);

        }
        Product product = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.img);
        Picasso.with(context).load(product.getImage()).into(imageView);
        Log.i("corentin", "Image url is: "+ product.getImage());


        TextView txtName = convertView.findViewById(R.id.nom_bien);
        txtName.setText(product.getName());
        Log.i("corentin", "Nom is : "+ product.getImage());

        TextView txtPrice = convertView.findViewById(R.id.prix_bien);
        txtPrice.setText(product.getPrice());
        Log.i("corentin", "Price is: "+ product.getImage());

        return convertView;
    }
}