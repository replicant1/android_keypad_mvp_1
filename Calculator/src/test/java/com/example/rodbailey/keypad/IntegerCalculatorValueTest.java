package com.example.rodbailey.keypad;

import org.junit.Assert;
import org.junit.Test;
import org.valid4j.errors.RequireViolation;

/**
 * Uninstrumented tests for IntegerCalculatorValue class.
 */
public class IntegerCalculatorValueTest {

    @Test
    public void contructWithLowestValue() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(IntegerCalculatorValue.VALUE_LOWEST);
        Assert.assertNotNull(value);
        Assert.assertEquals(IntegerCalculatorValue.VALUE_LOWEST, value.getValue());
    }

    @Test
    public void constructWithHighestValue() {
        IntegerCalculatorValue value = new IntegerCalculatorValue(IntegerCalculatorValue.VALUE_HIGHEST);
        Assert.assertNotNull(value);
        Assert.assertEquals(IntegerCalculatorValue.VALUE_HIGHEST, value.getValue());
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
}
