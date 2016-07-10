package com.example.rodbailey.keypad;

/**
 * Symbolic representation of every key in the ICalculatorView
 */
public enum KeypadKey {
    KEY_1, //
    KEY_2, //
    KEY_3, //
    KEY_4, //
    KEY_CLEAR_ALL, //
    KEY_PLUS, //
    KEY_MINUS, //
    KEY_EQUALS;//

    public boolean isNumeric() {
        return ((this == KEY_1) || (this == KEY_2) || (this == KEY_3) || (this == KEY_4));
    }

    public boolean isOperation() {
        return ((this == KEY_PLUS) || (this == KEY_MINUS) || (this == KEY_CLEAR_ALL) || (this == KEY_EQUALS));
    }
}
