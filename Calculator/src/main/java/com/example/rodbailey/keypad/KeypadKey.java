package com.example.rodbailey.keypad;

/**
 * Symbolic representation of every key in the ICalculatorView
 */
public enum KeypadKey {
    KEY_1, //
    KEY_2, //
    KEY_3, //
    KEY_4, //
    KEY_5, //
    KEY_6, //
    KEY_7, //
    KEY_8, //
    KEY_9, //
    KEY_CLEAR, //
    KEY_DIVIDE, //
    KEY_PLUS, //
    KEY_MINUS, //
    KEY_MULTIPLY, //
    KEY_EQUALS;//

    public boolean isNumeric() {
        return ((this == KEY_1) || (this == KEY_2) || (this == KEY_3) || (this == KEY_4) || (this == KEY_5)
                || (this == KEY_6) || (this == KEY_7) || (this == KEY_9));
    }

    public boolean isArithmeticOperation() {
        return ((this == KEY_DIVIDE) || (this == KEY_PLUS) || (this == KEY_MINUS) || (this == KEY_MULTIPLY));
    }
}
