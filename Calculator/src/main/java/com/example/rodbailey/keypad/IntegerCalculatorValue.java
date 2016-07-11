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

    /** The lowest value an IntegerCalculatorValue can have (inclusive) */
    public static final long VALUE_LOWEST = -9999;

    /** The highest value an IntegerCalculatorValue can have (exclusive) */
    public static final long VALUE_HIGHEST = 9999;

    private long value;

    /**
     * Default constructor. Constructs an IntegerCalculatorValue with a zero value.
     */
    public IntegerCalculatorValue() {
        this.value = 0L;
        ensure(getValue() == 0L);
    }

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

    /**
     * Constructs an IntegerCalculatorValue
     *
     * @param copyMe
     */
    public IntegerCalculatorValue(IntegerCalculatorValue copyMe) {
        require(copyMe != null);
        this.value = copyMe.getValue();
    }


    /**
     * Appends the given digit to the right end of the current value
     *
     * @param digit Must in [0,9] e.g. "123" -> "1230", "20" ->
     *              200", "0" -> "9"
     */
    public void appendDigit(long digit) {
        require(digit >= 0);
        require(digit <= 9);
        value = value * 10 + digit;
    }

    /**
     * Sets the current value to zero.
     */
    public void clear() {
        value = 0L;
        ensure(getValue() == 0L);
    }

    /** @return The current value as a long. Will be in [LOWEST, HIGHEST] */
    public long getValue() {
        ensure(value >= VALUE_LOWEST);
        ensure(value <= VALUE_HIGHEST);
        return value;
    }

    /**
     *
     * @return The current value as String e.g. "1", "10"
     */
    public String getValueAsString() {
        return Long.toString(value);
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
