package com.example.rodbailey.keypad;

/**
 * This interface must be implemented by any keypad view. It contains those directives delivered
 * from the IKeypadPresenter that instruct the ICalculatorView to make certain changes in its view
 * state.
 */
public interface ICalculatorView {

    /**
     * Briefly flashes the display, which means to briefly clear the display then redisplay it's previous
     * contents.
     */
    public void flashDisplay();

    /**
     * Displays the given string in the keypad's display area
     *
     * @param display The string to literally display.
     */
    public void setDisplay(String display);
}
