package com.example.rodbailey.keypad;

import static com.example.rodbailey.keypad.Log.log;

/**
 * The keypad itself.
 */
public class KeypadModel implements IKeypadModel {

    private static final String TAG = KeypadModel.class.getSimpleName();

    private StringBuffer register = new StringBuffer();

    public String getRegister() {
        return register.toString();
    }

    public void appendToRegister(char value) {
        log(TAG, "append to register value: " + value);
        register.append(value);
        log(TAG, "new register value: \"" + register.toString() + "\"");
    }

    public void clearRegister() {
        register.setLength(0);
        log(TAG, "register cleared. new register value: \"" + register.toString() + "\"");
    }
}
