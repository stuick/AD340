package com.example.locationmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

public class SecondActivity extends Activity {

    private final LinkedList<String> mCameraList = new LinkedList<>();
    private final LinkedList<String> mCameraLink = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private CameraListAdapter mAdapter;
    private static String LOG_TAG="Activite 2 :";
    private ArrayList<String>cameraDescription = new ArrayList<String>();
    private ArrayList<String>cameraURLs = new ArrayList<String>();
    private ArrayList<Double>cameraLatitude = new ArrayList<>();
    private ArrayList<Double>cameraLongitude = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle cameraData = intent.getExtras();
        cameraDescription = cameraData.getStringArrayList("descriptionArray");
        cameraURLs = cameraData.getStringArrayList("urlArray");
        cameraLatitude = (ArrayList<Double>) cameraData.getSerializable("latitudeArray");
        cameraLongitude = (ArrayList<Double>) cameraData.getSerializable("longitudeArray");

        int size = cameraURLs.size();

        Log.d(LOG_TAG, String.valueOf(size));
        for(int i=0;i<size;i++){
            int num=i+1;
            mCameraList.addLast(num+"/ "+cameraDescription.get(i));
            mCameraLink.addLast(cameraURLs.get(i));
        }




        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new CameraListAdapter(this, mCameraList,mCameraLink,cameraLatitude,cameraLongitude);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
