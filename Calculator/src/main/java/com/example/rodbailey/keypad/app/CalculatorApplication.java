package com.example.rodbailey.keypad.app;

import android.app.Application;
import android.content.Context;

/**
 * The application representing all of the Calculator app. This class exists solely for the
 * purposes of providing global access to the Context without having to continually pass it
 * around.
 */
public class CalculatorApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
