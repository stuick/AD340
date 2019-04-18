package com.example.intent_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public static String MESSAGE_ID="message_send";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void onClick(View button) {

        EditText textbox = (EditText)findViewById(R.id.message_box);
        String message = textbox.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MESSAGE_ID, message);
        startActivity(intent);

    }
}
