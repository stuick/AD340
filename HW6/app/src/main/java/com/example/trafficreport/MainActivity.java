package com.example.trafficreport;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private static String LOG_TAG = "SI YA L HOMME";
    private TextView mTextview;
    private ArrayList<String>cameraName = new ArrayList<String>();
    private ArrayList<String>cameraURL = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextview = findViewById(R.id.mainText);
    }


    protected void onClick(View button) {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {
            Bundle queryBundle = new Bundle();
            getSupportLoaderManager().restartLoader(0,queryBundle,this);
            mTextview.setText("Please Wait ... ");


        }else{
            mTextview.setText("Please Check your network connection.");
        }






    }

    @NonNull
    @Override
    public Loader onCreateLoader(int id, @Nullable Bundle bundle) {
        return new CameraLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader <String>loader, String data) {

        try{
            JSONObject jsonObject = new JSONObject(data);
            JSONArray features = jsonObject.getJSONArray("Features");
            int size =features.length();


            for (int i=0; i<size;i++){
                JSONObject infos = features.getJSONObject(i);
                JSONArray camera = infos.getJSONArray("Cameras");
                JSONObject cameraDetails = camera.getJSONObject(0);
                String description = cameraDetails.getString("Description");
                String imageURL = cameraDetails.getString("ImageUrl");
                cameraName.add(description);
                cameraURL.add(imageURL);

                Log.d(LOG_TAG, description);
                Log.d(LOG_TAG, imageURL);
            }
            Bundle cameraData = new Bundle();
            cameraData.putStringArrayList("descriptionArray",cameraName);
            cameraData.putStringArrayList("urlArray",cameraURL);

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtras(cameraData);
            startActivity(intent);
        }catch (Exception e){
            LOG_TAG ="MARCHE PAS";
            Log.d(LOG_TAG, "");
        }

    }


    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }
}
