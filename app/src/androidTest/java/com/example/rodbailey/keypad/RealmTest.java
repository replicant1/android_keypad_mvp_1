package com.example.rodbailey.keypad;

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
 * Instrumented test of storing Pin instances in a Realm database.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RealmTest {

    private static final String TAG = RealmTest.class.getSimpleName();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    public RealmConfiguration config;

    public Realm realm;

    /**
     * Remove all Pin records from database before each @Test is run. Note need for "deleteRealmIfMigrationNeeded"
     * when I moved this code from KeypadTest to the new RealmTest class.
     */
    @Before
    public void before() {
        Log.log(TAG, "Into before");
        config = new RealmConfiguration.Builder(mActivityRule.getActivity()).deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(config);
        emptyRealmDatabase();
        Log.log(TAG, "Exiting before with realm=" + realm);
    }

    /**
     * Close the realm database connection after each @Test is run
     */
    @After
    public void after() {
        Log.log(TAG, "Into after with realm=" + realm);
        realm.close();
    }

    /**
     * Utility method to delete all Pin records from the database
     */
    private void emptyRealmDatabase() {
        realm.beginTransaction();
        RealmResults<Pin> allPins = realm.where(Pin.class).findAll();
        allPins.deleteAllFromRealm();
        realm.commitTransaction();
    }

    /**
     * Utility method to add two Pin records to the database, with:
     * id = 1, name = John Smith, numericCode = 1234
     * and
     * id = 2, name = Jane Doe, numericCode = 5678
     */
    private void addPinsToRealmDatabase() {
        // Default realm database is /data/user/0/com.example.rodbailey.keypad/files/default.realm
        // Due to symbolic links, /data/data/com.example.rodbailey.keypad/files/default.realm
        realm.beginTransaction();

        Pin pin1 = realm.createObject(Pin.class);
        pin1.setId(1);
        pin1.setName("John Smith");
        pin1.setNumericCode("1234");

        Pin pin2 = realm.createObject(Pin.class);
        pin2.setId(2);
        pin2.setName("Jane Doe");
        pin2.setNumericCode("5678");

        realm.commitTransaction();
    }



    /**
     * Test retrieval of the first Pin instance from the database
     */
    @Test
    public void testReadRealmDatabase() {
        addPinsToRealmDatabase();

        Pin retrievedPin = realm.where(Pin.class).findFirst();
        Assert.assertNotNull(retrievedPin);
        Assert.assertEquals(retrievedPin.getId(), 1);
        Assert.assertEquals(retrievedPin.getName(), "John Smith");
        Assert.assertEquals(retrievedPin.getNumericCode(), "1234");
        Log.log(TAG, "retrieved Pin=" + retrievedPin);
    }

    /**
     * Test retrieval using a simple "finaAll" query. Find all Pins where name == "John Smith"
     */
    @Test
    public void testQueryRealmDatabase() {
        addPinsToRealmDatabase();

        RealmQuery<Pin> query = realm.where(Pin.class);
        query.equalTo("name", "John Smith");
        RealmResults<Pin> results = query.findAll();
        Assert.assertNotNull(results);
        Assert.assertEquals(1, results.size());

        // Pin at location 0, has id 1
        Pin queryPin = results.first();
        Assert.assertEquals(queryPin.getId(), 1);
        Assert.assertEquals(queryPin.getName(), "John Smith");
        Assert.assertEquals(queryPin.getNumericCode(), "1234");
    }

    @Test
    public void testIterateOverResults() {
        RealmResults<Pin> results = realm.where(Pin.class).findAll();
        for (Pin result : results) {
            Log.log(TAG, "Iterated result=" + result);
        }
    }
}
