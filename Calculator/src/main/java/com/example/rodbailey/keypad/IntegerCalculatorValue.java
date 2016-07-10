package com.example.rodbailey.keypad;

import static org.valid4j.Assertive.require;
import static org.valid4j.Assertive.ensure;

import org.valid4j.Assertive;

/**
 * A value that can be considered by the IntegerCalculator. This value might be the current
 * value of the "memory" or the value of the "register" in the calculator. The results of mathematical
 * operations cannot exceed what can be stored in an IntegerCalculatorValue, otherwise you get an Underflow or
 * Oveflow error.
 */
public class IntegerCalculatorValue {

    public static final long VALUE_LOWEST = -9999;

    public static final long VALUE_HIGHEST = 9999;

    private long value;

    /**
     * Constructs an IntegerCalculatorValue
     *
     * @param value Must be in the range [-9999, 9999]
     */
    public IntegerCalculatorValue(long value) {
        require(value >= VALUE_LOWEST);
        require(value <= VALUE_HIGHEST);
        this.value = value;
    }

    public IntegerCalculatorValue(IntegerCalculatorValue copyMe) {
        require(copyMe != null);
        this.value = copyMe.getValue();
    }

    public void appendDigit(long digit) {
        value = value * 10 + digit;
    }

    public void clear() {
        value = 0L;
        ensure(getValue() == 0L);
    }

    public long getValue() {
        ensure(value >= VALUE_LOWEST);
        ensure(value <= VALUE_HIGHEST);
        return value;
    }

    public String getValueAsString() {
        return Long.toString(value);
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
