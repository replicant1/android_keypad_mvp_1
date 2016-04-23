package com.example.rodbailey.keypad;

/**
 * This interface must be implemented by any party wanting to present a KeypadView.
 */
public interface IKeypadPresenter {

    /**
     * Invoked when a key on the keypad is tapped by the user.
     *
     * @param key The key the user tapped.
     */
    public void keyPressed(KeypadKey key);
}
