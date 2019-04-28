package com.example.viewandgroupview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    final static String TAG = "MainActivity dit: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void button1click(View view){
        Intent intent=new Intent(this,MovieList.class);
        startActivity(intent);
    }
}
