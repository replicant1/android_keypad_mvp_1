package com.example.rodbailey.keypad;

import android.util.Log;

/**
 *
 */
public class KeypadPresenter implements IKeypadPresenter {
    private static final String TAG = KeypadPresenter.class.getSimpleName();
    private final KeypadModel keypadModel;

    public KeypadPresenter() {
        keypadModel = new KeypadModel();
    }

    @Override
    public void keyPressed(KeypadKey key) {
        Log.d(TAG, "keyPressed: " + key);
        if (key.isNumeric()) {
            char charToRegister = numericKeyToChar(key);
            keypadModel.appendToRegister(charToRegister);
        }
        else if (key == KeypadKey.KEY_CLEAR) {
            keypadModel.clearRegister();
        }
        else if (key == KeypadKey.KEY_OK) {
            // Do what?
        }

    }

    private char numericKeyToChar(KeypadKey key) {
        char result = ' ';

        switch (key) {
            case KEY_1:
                result = '1';
                break;
            case KEY_2:
                result = '2';
                break;
            case KEY_3:
                result = '3';
                break;
            case KEY_4:
                result = '4';
                break;
            case KEY_5:
                result = '5';
                break;
            case KEY_6:
                result = '6';
                break;
            case KEY_7:
                result = '7';
                break;
            case KEY_8:
                result = '8';
                break;
            case KEY_9:
                result = '9';
                break;
        }

        return result;
    }
}
