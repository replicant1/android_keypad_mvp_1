package com.example.rodbailey.keypad;

/**
 * Symbolic representation of every key in the ICalculatorView
 */
public enum KeypadKey {
    KEY_1, KEY_2, KEY_3, KEY_4, KEY_5, KEY_6, KEY_7, KEY_8, KEY_9, KEY_CLEAR, KEY_OK;

    public boolean isNumeric() {
        return ((this != KEY_CLEAR) && (this != KEY_OK));
    }
}
