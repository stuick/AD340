package com.example.trafficreport;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    private static String myURL ="https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2";


    static String getCameraInfo() {

        // Set up variables for the try block that need to be closed in the
        // finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String cameraJSONString = null;

        try {
            URL requestURL = new URL(myURL);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));


            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                // Add the current line to the string.
                builder.append(line);
            }

            if (builder.length() == 0) {
                // Stream was empty.  Exit without parsing.
                return null;
            }

            cameraJSONString = builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return cameraJSONString;
    }
}
