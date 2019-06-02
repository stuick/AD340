package com.example.scorekeeper;

import android.content.Intent;
import android.os.Bundle;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ScorekeeperTest {
    @Before
    public void setUp() {
        Intent intent = new Intent(InstrumentationRegistry.getTargetContext(), MainActivity.class);
        activityRule.launchActivity(intent);
    }


    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testGamePageValidateButton_negative32Button(){
        GamePage fragment = new GamePage();
        Bundle bundle = new Bundle();
        bundle.putString("player1", "testPlayer1");
        bundle.putString("player2", "testPlayer2");
        fragment.setArguments(bundle);

        activityRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.host_fragment, fragment)
                .commit();
        onView(withId(R.id.p1_neg_32)).perform(click());
        onView(withId(R.id.p1Round)).check(matches(withText("-32")));

        onView(withId(R.id.p2_neg_32)).perform(click());
        onView(withId(R.id.p2Round)).check(matches(withText("-32")));



        onView(withId(R.id.p1Round))
                .perform(typeText("150"));
        onView(withId(R.id.p1Round)).check(matches(withText("KO")));
        onView(withId(R.id.p2Round)).check(matches(withText("WINNER")));
    }

    @Test
    public void testGamePageValidateButton_endGameTest(){
        GamePage fragment = new GamePage();
        Bundle bundle = new Bundle();
        bundle.putString("player1", "testPlayer1");
        bundle.putString("player2", "testPlayer2");
        fragment.setArguments(bundle);

        activityRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.host_fragment, fragment)
                .commit();



        onView(withId(R.id.p1Round))
                .perform(typeText("150"));

        onView(withId(R.id.butt_validate)).perform(click());
        onView(withId(R.id.p1Round)).check(matches(withText("KO")));
        onView(withId(R.id.p2Round)).check(matches(withText("WINNER")));
    }

    public void testGamePageCancelLastButton(){
        GamePage fragment = new GamePage();
        Bundle bundle = new Bundle();
        bundle.putString("player1", "testPlayer1");
        bundle.putString("player2", "testPlayer2");
        fragment.setArguments(bundle);

        activityRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.host_fragment, fragment)
                .commit();

        onView(withId(R.id.p1_neg_32)).perform(click());
        onView(withId(R.id.p2Round))
                .perform(typeText("100"));
        onView(withId(R.id.butt_validate)).perform(click());

        onView(withId(R.id.p1_neg_32)).perform(click());
        onView(withId(R.id.p2Round))
                .perform(typeText("40"));
        onView(withId(R.id.butt_validate)).perform(click());

        onView(withId(R.id.butt_cancel)).perform(click());
        onView(withId(R.id.p1Round)).check(matches(withText("-32")));
        onView(withId(R.id.p2Round)).check(matches(withText("100")));

    }

    public void testCreatePlayerNoName(){
        GamePage fragment = new GamePage();
        Bundle bundle = new Bundle();
        bundle.putString("player1", "");
        bundle.putString("player2", "");
        fragment.setArguments(bundle);

        activityRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.host_fragment, fragment)
                .commit();


        onView(withId(R.id.first)).check(matches(withText("AHMED")));
        onView(withId(R.id.second)).check(matches(withText("AICHA")));
    }

    public void testCreatePlayerNameGiven(){
        GamePage fragment = new GamePage();
        Bundle bundle = new Bundle();
        bundle.putString("player1", "p1");
        bundle.putString("player2", "p2");
        fragment.setArguments(bundle);

        activityRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.host_fragment, fragment)
                .commit();


        onView(withId(R.id.first)).check(matches(withText("p1")));
        onView(withId(R.id.second)).check(matches(withText("p2")));
    }


}
