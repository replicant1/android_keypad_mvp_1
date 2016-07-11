package com.example.rodbailey.keypad;

import org.junit.Assert;
import org.junit.Test;
import org.valid4j.errors.RequireViolation;

/**
 * JUnit 4 tests for the IntegerCalculatorValue class.
 */
public class IntegerCalculatorValueTest {

    @Test
    public void appendNonZeroToNonZero() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(5L);
        value.appendDigit(6);
        Assert.assertEquals(56, value.getValue());
        Assert.assertEquals("56", value.getValueAsString());
    }

    @Test
    public void appendNonZeroToZero() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(0L);
        value.appendDigit(5L);
        Assert.assertEquals(5, value.getValue());
        Assert.assertEquals("5", value.getValueAsString());
    }

    @Test
    public void appendZeroToNonZero() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(5L);
        value.appendDigit(0L);
        Assert.assertEquals(50, value.getValue());
        Assert.assertEquals("50", value.getValueAsString());
    }

    @Test
    public void appendZeroToZero() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(0L);
        value.appendDigit(0);
        Assert.assertEquals(0, value.getValue());
        Assert.assertEquals("0", value.getValueAsString());
    }

    @Test
    public void clearNonEmpty() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(5L);
        value.clear();
        Assert.assertEquals(0, value.getValue());
    }

    @Test
    public void clearEmpty() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(0L);
        value.clear();
        Assert.assertEquals(0, value.getValue());
    }

    @Test
    public void constructWithHighestValue() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(IntegerCalculatorValue.VALUE_HIGHEST);
        Assert.assertNotNull(value);
        Assert.assertEquals(IntegerCalculatorValue.VALUE_HIGHEST, value.getValue());
    }

    @Test
    public void constructWithTooHighValueGivesRequireViolation() {
        boolean rvGenerated = false;

        try {
            IntegerCalculatorValue value = new IntegerCalculatorValue(
                    IntegerCalculatorValue.VALUE_HIGHEST + 1);
        }
        catch (RequireViolation rv) {
            rvGenerated = true;
        }

        Assert.assertTrue(rvGenerated);
    }

    @Test
    public void constructWithTooLowValueGivesRequireViolation() {
        boolean rvGenerated = false;

        try {
            new IntegerCalculatorValue(IntegerCalculatorValue.VALUE_LOWEST - 1);
        }
        catch (RequireViolation rv) {
            rvGenerated = true;
        }

        Assert.assertTrue(rvGenerated);
    }

    @Test
    public void contructWithLowestValue() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(IntegerCalculatorValue.VALUE_LOWEST);
        Assert.assertNotNull(value);
        Assert.assertEquals(IntegerCalculatorValue.VALUE_LOWEST, value.getValue());
    }

    @Test
    public void copyConstructorCopiesValue() {
        IntegerCalculatorValue value_1 = new IntegerCalculatorValue(1L);
        IntegerCalculatorValue value_1_copy = new IntegerCalculatorValue(1L);
        Assert.assertEquals(value_1.getValue(), value_1_copy.getValue() );
    }

    @Test
    public void defaultConstructorHasZeroValue() {
        IntegerCalculatorValue value = new IntegerCalculatorValue();
        Assert.assertEquals(0, value.getValue());
    }


}
