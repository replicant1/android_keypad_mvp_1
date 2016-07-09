package com.example.rodbailey.keypad;

/**
 * This interface must be implemented by any party wanting to present a CalculatorFragment. It
 * receives messzgs from a corresponding view whenever some significant user event occurs. This
 * presenter coordinates two parties - an ICalculatorView and an ICalculatorModel.</p>
 * The following events are received on the event bus:
 */
public interface ICalculatorPresenter {

    /**
     * Invoked when a key on the keypad is tapped by the user.
     *
     * @param key The key the user tapped.
     */
    public void keyPressed(KeypadKey key);
}
