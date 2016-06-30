package com.example.rodbailey.keypad;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class KeypadTest {

    private static final String TAG = KeypadTest.class.getSimpleName();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void testClickingNumber1KeyPuts1OnScreen() {
        // Click the "1" button
        Espresso.onView(ViewMatchers.withId(R.id.keypad_button_1)).perform(ViewActions.click());

        // Check there is a "1" on the screen
        Espresso.onView(ViewMatchers.withId(R.id.keypad_display)).check(ViewAssertions.matches(ViewMatchers.withText("1")));
    }

    @Test
    public void testClickingNumbers1and2Puts12OnScreen() {
        // Click the "1" button then the "2" button
        Espresso.onView(ViewMatchers.withId(R.id.keypad_button_1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.keypad_button_2)).perform(ViewActions.click());

        // Check there is a "12" on the screen
        Espresso.onView(ViewMatchers.withId(R.id.keypad_display)).check(ViewAssertions.matches(ViewMatchers.withText("12")));
    }

    @Test
    public void testClearButtonEmptiesDisplay() {
        // Click the "3" button
        Espresso.onView(ViewMatchers.withId(R.id.keypad_button_3)).perform(ViewActions.click());
        // Click the "Clear" button
        Espresso.onView(ViewMatchers.withId(R.id.keypad_button_clear)).perform(ViewActions.click());
        // Check the screen is empty string
        Espresso.onView(ViewMatchers.withId(R.id.keypad_display)).check(ViewAssertions.matches(ViewMatchers.withText("")));
    }
}