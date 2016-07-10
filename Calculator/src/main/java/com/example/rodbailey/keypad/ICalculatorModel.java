package com.example.rodbailey.keypad;

/**
 * Contains all the state information for a calculator. All state is captured in two places:
 * the "register" and the "memory". The "register" is the number you are currently typing in,
 * the contents of which is always reflected on the calculator's display. The "memory" is the
 * running "tally" of the current operation and is the implied second argument to the mathematical
 * operation being performed. The first argument is the register.</p>
 * <p>
 * The ICalculatorModel also contains the business logic for the calculator. It is an integer-only
 * calculator. Any operation resulting in a fractional number will be rounded to the nearest
 * integer.
 * </p>
 * When a property changes value, an event is broadcast on the event bus. The following property change events
 * are broadcast:
 * <ul>
 * <li>RegisterPropertyChangedEvent</li>
 * <li>MemoryPropertyChangedEvent</li>
 * </ul>
 */
public interface ICalculatorModel {

    /**
     * Sets both register and model values to zero. Also cancels any pending operations.
     */
    public void clearAll();

    /**
     * @return The current value of the calculator's memory. This is the off-screen, running
     * tally and the implied second argument of all binary operations.
     */
    public IntegerCalculatorValue getMemory();

    /**
     * @return The current register value.
     */
    public IntegerCalculatorValue getRegister();

    /**
     * Performs the mathematical operation: register = memory + register
     */
    public void performOperationAdd() throws CalculatorOverflowException;

    /**
     * Executes any pending operation.
     */
    public void performOperationEqual() throws CalculatorOverflowException, CalculatorUnderflowException;

    /**
     * Performs the mathematical operation: register = memory - register
     */
    public void performOperationSubtract() throws CalculatorOverflowException, CalculatorUnderflowException;

    /**
     * @param value The new memory value
     */
    public void setMemory(IntegerCalculatorValue value);

    /**
     * Sets the calculator's register to have the given value.
     *
     * @param value New value of register. Zero or greater.
     */
    public void setRegister(IntegerCalculatorValue value);
}
