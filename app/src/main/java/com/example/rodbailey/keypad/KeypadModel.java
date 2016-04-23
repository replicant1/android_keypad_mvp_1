package com.example.rodbailey.keypad;

/**
 * The keypad itself.
 */
public class KeypadModel {

    private static final String TAG = KeypadModel.class.getSimpleName();

    private StringBuffer register = new StringBuffer();

    public KeypadModel() {

    }

    public String getRegister() {
        return register.toString();
    }

    public void appendToRegister(char value) {
        System.out.println("append to register value: " + value);

        register.append(value);

        System.out.println("new register value: \"" + register.toString() + "\"");
    }

    public void clearRegister() {
        register.setLength(0);
        System.out.println("register cleared. new register value: \"" + register.toString() + "\"");
    }
}
