package com.example.agence_du_soleil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICall {

    String targeturl = "188.213.31.179:8082";
    String urlParameters;

    public static String execute_api(String targeturl, String urlParameters) throws IOException {

        HttpURLConnection connection = null;

        URL url = new URL(targeturl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        connection.setUseCaches(false);
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.close();

        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();


    }
}