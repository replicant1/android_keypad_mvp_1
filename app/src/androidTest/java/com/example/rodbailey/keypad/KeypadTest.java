package com.example.rodbailey.keypad;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.rodbailey.keypad.pinservice.Pin;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.Realm;
import io.realm.RealmConfiguration;

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
    public void testCreateRealmDatabase() {
        // Default realm database is /data/user/0/com.example.rodbailey.keypad/files/default.realm
        // Due to symbolic links, /data/data/com.example.rodbailey.keypad/files/default.realm
        Log.log(TAG, "--------------------");
        Log.log(TAG, "Realm absolute database directory is: " + mActivityRule.getActivity().getFilesDir().getAbsolutePath());

        RealmConfiguration config = new RealmConfiguration.Builder(mActivityRule.getActivity()).build();
        Realm realm = Realm.getInstance(config);

        Log.log(TAG, "Performing CREATE for a Pin John Smith, 1234");

        realm.beginTransaction();
        Pin pin = realm.createObject(Pin.class);
        pin.setId(1);
        pin.setName("John Smith");
        pin.setNumericCode("1234");
        realm.commitTransaction();


        Log.log(TAG, "Created new Pin: 1,John Smith,1234");

        Pin retrievedPin = realm.where(Pin.class).findFirst();
        Log.log(TAG, "retrieved Pin=" + retrievedPin);
        Log.log(TAG, "--------------------");


        realm.close();
    }

    /*

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
    } */
}