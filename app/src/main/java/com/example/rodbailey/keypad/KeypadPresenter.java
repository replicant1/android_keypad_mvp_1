package com.example.rodbailey.keypad;


import static com.example.rodbailey.keypad.Log.log;

/**
 *
 */
public class KeypadPresenter implements IKeypadPresenter {
    private static final String TAG = KeypadPresenter.class.getSimpleName();
    private final IKeypadModel keypadModel;
    private final IKeypadView keypadView;

    /**
     * You have to pass in a model, otherwise how can you tell if the
     * presenter is working or not? You need to have access to the model
     * to tell if the presenter is modifying it correctly, which precludes
     * creating it privately.
     *
     * @param model
     * @param view
     */
    public KeypadPresenter(IKeypadView view, IKeypadModel model) {
        keypadModel = model;
        keypadView = view;
    }

    @Override
    public void keyPressed(KeypadKey key) {
        log(TAG, "keyPressed: " + key);

        // Pass user interaction onto the model
        if (key.isNumeric()) {
            char charToRegister = numericKeyToChar(key);
            keypadModel.appendToRegister(charToRegister);
        } else if (key == KeypadKey.KEY_CLEAR) {
            keypadModel.clearRegister();
        } else if (key == KeypadKey.KEY_OK) {
            // Do what?
        }

        // Pass new model contents back up to view
        String newDisplay = keypadModel.getRegister();
        keypadView.setDisplay(newDisplay);
    }

    private char numericKeyToChar(KeypadKey key) {
        char result = ' ';

        switch (key) {
            case KEY_1:
                result = '1';
                break;
            case KEY_2:
                result = '2';
                break;
            case KEY_3:
                result = '3';
                break;
            case KEY_4:
                result = '4';
                break;
            case KEY_5:
                result = '5';
                break;
            case KEY_6:
                result = '6';
                break;
            case KEY_7:
                result = '7';
                break;
            case KEY_8:
                result = '8';
                break;
            case KEY_9:
                result = '9';
                break;
        }

        return result;
    }
}
