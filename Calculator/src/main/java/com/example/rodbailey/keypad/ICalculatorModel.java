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
 *     <li>RegisterPropertyChangedEvent</li>
 *     <li>MemoryPropertyChangedEvent</li>
 * </ul>
 */
public interface ICalculatorModel {

    /**
     * Sets the current register's value to zero. Equivalent to calling #setRegister(0)
     */
    public void clearRegister();

    /**
     * @return The current value of the calculator's memory. This is the off-screen, running
     * tally and the implied second argument of all binary operations.
     */
    public long getMemory();

    /**
     * @return The current register value.
     */
    public long getRegister();

    /**
     * Performs the mathematical operation: register = memory + register
     */
    public void performOperationAdd();

    /**
     * Performs the mathematical operation: register = round(memory / register).
     */
    public void performOperationDivide();

    /**
     * Performs the mathematical operation: register = memory * register
     */
    public void performOperationMultiply();

    /**
     * Performs the mathematical operation: register = memory - register
     */
    public void performOperationSubtract();

    /**
     * @param value The new memory value
     */
    public void setMemory(long value);

    /**
     * Sets the calculator's register to have the given value.
     *
     * @param value New value of register. Zero or greater.
     */
    public void setRegister(long value);
}
