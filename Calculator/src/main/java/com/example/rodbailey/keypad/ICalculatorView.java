package com.example.rodbailey.keypad;

/**
 * This interface must be implemented by any keypad view. It contains those directives delivered
 * from the IKeypadPresenter that instruct the ICalculatorView to make certain changes in its view
 * state.
 */
public interface ICalculatorView {

    public void clearDisplay();

    /**
     * Briefly flashes the display, which means to briefly blank out the display (remove all digits) then redisplay
     * it's previous contents.
     */
    public void flashDisplay();

    /**
     * Displays the given value in the keypad's display area
     *
     * @param display The string to literally display. e.g. "25.4302", "-23.12"
     */
    public void setDisplay(IntegerCalculatorValue display);
}
