package com.example.scorekeeper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements CreatePlayer.OnNextClickListener {



    @Override
    public void OnMainFragmentNextClick(CreatePlayer fragment) {
        swapFragments(fragment);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        CreatePlayer fragment = new CreatePlayer();
        fragmentTransaction.add(R.id.host_fragment, fragment);
        fragmentTransaction.commit();

    }

    public void swapFragments(Fragment fragment) {
        Fragment newFragment = null;

        if (fragment instanceof CreatePlayer) {
            newFragment = new GamePage();
        } else {
            newFragment = new CreatePlayer();
        }

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.host_fragment, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

}
