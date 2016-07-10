package com.example.rodbailey.keypad;

/**
 * A value that can be considered by the IntegerCalculator. This value might be the current
 * value of the "memory" or the value of the "register" in the calculator. The results of mathematical
 * operations cannot exceed what can be stored in an IntegerCalculatorValue, otherwise you get an Underflow or
 * Oveflow error.
 */
public class IntegerCalculatorValue {

    private long value;

    /**
     * Constructs an IntegerCalculatorValue
     *
     * @param value Must be in the range [-9999, 9999]
     */
    public IntegerCalculatorValue(long value) {
        this.value = value;
    }

    public IntegerCalculatorValue(IntegerCalculatorValue copyMe) {
        this.value = copyMe.getValue();
    }

    public long getValue() {
        return value;
    }

    public String getValueAsString() {
        return Long.toString(value);
    }

    public void appendDigit(long digit) {
        value = value * 10 + digit;
    }

    public void clear() {
        value = 0L;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
