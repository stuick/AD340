package com.example.intent_activities;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{

    private static final String TAG = "MAGDADA SAYS ...";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();//I spent hours trying to understand the Note:Note: you will lose a point if you hard code the name of your intent in BOTH activities. But I always have to put the name in here
        String message = intent.getStringExtra(MainActivity.MESSAGE_ID);
        TextView label = findViewById(R.id.intent_message);
        label.setText(message);

        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "resumed");
        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "destroyed");
    }

}
