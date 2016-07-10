package com.example.rodbailey.keypad;

import hugo.weaving.DebugLog;

import static com.example.rodbailey.keypad.util.Log.log;

/**
 * The state and business logic of the calculator.
 *
 * @see ICalculatorModel
 */
public class CalculatorModel implements ICalculatorModel {

    private static final String TAG = CalculatorModel.class.getSimpleName();

    private IntegerCalculatorValue register = new IntegerCalculatorValue(0);

    private IntegerCalculatorValue memory = new IntegerCalculatorValue(0);

    @DebugLog
    public void clearAll() {
        register.clear();
        log(TAG, "register cleared. new register value: \"" + register.toString() + "\"");
    }

    @Override
    public IntegerCalculatorValue getMemory() {
        return memory;
    }

    public IntegerCalculatorValue getRegister() {
        return register;
    }

    @Override
    public void performOperationAdd() {

    }

    @Override
    public void performOperationEqual() throws CalculatorOverflowException, CalculatorUnderflowException {

    }

    @Override
    public void performOperationSubtract() {

    }

    @Override
    public void setMemory(IntegerCalculatorValue value) {
        memory = new IntegerCalculatorValue(value);
    }

    @Override
    public void setRegister(IntegerCalculatorValue value) {
        register = new IntegerCalculatorValue(value);
    }
}
