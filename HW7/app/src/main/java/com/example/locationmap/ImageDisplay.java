package com.example.locationmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageDisplay extends AppCompatActivity {

    private ImageView image;
    String url = "http://www.seattle.gov/trafficcams/images/";
    StringBuilder fullUrl = new StringBuilder();
    private String LOG_TAG = "Image Display dit : ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_display);

        Intent intent = getIntent();
        String imageName = intent.getExtras().getString("cameralink");
        fullUrl.append(url);
        fullUrl.append(imageName);

        Log.d(LOG_TAG, "GOOOOOOOOOOD");
        image = (ImageView)findViewById(R.id.image_view);
        loadImageFromUrl(fullUrl.toString());


    }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).into(image);

    }
}
