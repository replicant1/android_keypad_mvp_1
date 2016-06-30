package com.example.rodbailey.keypad.util;

import android.util.*;
import android.util.Log;

import timber.log.Timber;

/**
 * Created by rodbailey on 29/06/2016.
 */
public class ReleaseTree extends Timber.Tree {
    @Override
    protected boolean isLoggable(int priority) {
        return ((priority == android.util.Log.WARN) || (priority == android.util.Log.ERROR) ||
                (priority == android.util.Log.INFO));
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {

    }


}
