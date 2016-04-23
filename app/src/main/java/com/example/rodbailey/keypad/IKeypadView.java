package com.example.rodbailey.keypad;

/**
 * This interface must be implemented by any keypad view. It contains those directives delivered
 * from the IKeypadPresented that instruct the IKeypadView to make certain changes in its view
 * state.
 */
public interface IKeypadView {

    /**
     * Displays the given string in the keypad's display area
     *
     * @param display The string to literally display.
     */
    public void setDisplay(String display);

    /**
     * Empties the keypad's display area
     */
    public void clearDisplay();
}
