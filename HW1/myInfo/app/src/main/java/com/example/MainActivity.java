package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView name = new TextView(this);
        TextView interest = new TextView( this);
        name.setText("FirstName: Ahmedsidik \nLastName: Diallo\n\n");
        interest.setText("My dream is to develop an app that can help People to educate themselves and have fun at the same time.");
        LinearLayout allViews = new LinearLayout(this);
        allViews.setOrientation(LinearLayout.VERTICAL);
        allViews.addView(name);
        allViews.addView(interest);
        setContentView(allViews);

    }
}
