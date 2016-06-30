package com.example.rodbailey.keypad;

import hugo.weaving.DebugLog;

import static com.example.rodbailey.keypad.util.Log.log;

/**
 * The keypad itself.
 */
public class CalculatorModel implements ICalculatorModel {

    private static final String TAG = CalculatorModel.class.getSimpleName();

    private StringBuffer register = new StringBuffer();

    public String getRegister() {
        return register.toString();
    }

    @DebugLog
    public void appendToRegister(char value) {
        log(TAG, "append to register value: " + value);
        register.append(value);
        log(TAG, "new register value: \"" + register.toString() + "\"");
    }

    @DebugLog
    public void clearRegister() {
        register.setLength(0);
        log(TAG, "register cleared. new register value: \"" + register.toString() + "\"");
    }
}
