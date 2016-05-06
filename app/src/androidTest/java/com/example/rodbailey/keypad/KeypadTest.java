package com.example.rodbailey.keypad;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.rodbailey.keypad.pinservice.Pin;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class KeypadTest {

    private static final String TAG = KeypadTest.class.getSimpleName();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    public RealmConfiguration config;

    public Realm realm;

    @Before
    public void before() {
        config = new RealmConfiguration.Builder(mActivityRule.getActivity()).build();
        realm = Realm.getInstance(config);
        emptyRealmDatabase();
    }

    @After
    public void after() {
        realm.close();
    }

    private void emptyRealmDatabase() {
        realm.beginTransaction();
        RealmResults<Pin> allPins = realm.where(Pin.class).findAll();
        allPins.deleteAllFromRealm();
        realm.commitTransaction();
    }

    private void addPinToRealmDatabase() {
        // Default realm database is /data/user/0/com.example.rodbailey.keypad/files/default.realm
        // Due to symbolic links, /data/data/com.example.rodbailey.keypad/files/default.realm
        realm.beginTransaction();
        Pin pin = realm.createObject(Pin.class);
        pin.setId(1);
        pin.setName("John Smith");
        pin.setNumericCode("1234");
        realm.commitTransaction();
    }

    @Test
    public void testReadRealmDatabase() {
        addPinToRealmDatabase();

        Pin retrievedPin = realm.where(Pin.class).findFirst();
        Assert.assertNotNull(retrievedPin);
        Assert.assertEquals(retrievedPin.getId(), 1);
        Assert.assertEquals(retrievedPin.getName(), "John Smith");
        Assert.assertEquals(retrievedPin.getNumericCode(), "1234");
        Log.log(TAG, "retrieved Pin=" + retrievedPin);
    }

    @Test
    public void testQueryRealmDatabase() {
        addPinToRealmDatabase();
        
        RealmQuery<Pin> query = realm.where(Pin.class);
        query.equalTo("name", "John Smith");
        RealmResults<Pin> results = query.findAll();
        Assert.assertNotNull(results);
        Assert.assertEquals(1, results.size());

        Pin queryPin = results.first();
        Assert.assertEquals(queryPin.getId(), 1);
        Assert.assertEquals(queryPin.getName(), "John Smith");
        Assert.assertEquals(queryPin.getNumericCode(), "1234");
        Log.log(TAG, "queried Pin=" + queryPin);
    }

    @Test
    public void testComplexQueryRealmDatabase() {

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