package com.example.rodbailey.keypad;


import hugo.weaving.DebugLog;
import timber.log.Timber;

import static com.example.rodbailey.keypad.util.Log.log;

/**
 *
 */
public class CalculatorPresenter implements ICalculatorPresenter {
    private static final String TAG = CalculatorPresenter.class.getSimpleName();

    private final ICalculatorModel keypadModel;

    private final ICalculatorView keypadView;

    /**
     * You have to pass in a model, otherwise how can you tell if the
     * presenter is working or not? You need to have access to the model
     * to tell if the presenter is modifying it correctly, which precludes
     * creating it privately.
     *
     * @param model
     * @param view
     */
    public CalculatorPresenter(ICalculatorView view, ICalculatorModel model) {
        keypadModel = model;
        keypadView = view;
    }

    @DebugLog
    @Override
    public void keyPressed(KeypadKey key) {
        Timber.d("keyPressed: %s", key);

        // Pass user interaction onto the model
        if (key.isNumeric()) {
            long toLong = numericKeyToLong(key);
            Timber.d("toLong=%d", toLong);

            IntegerCalculatorValue register = keypadModel.getRegister();
            Timber.d("register=%s", register);

            register.appendDigit(toLong);

            Timber.d("register afert append=%s", register);

            keypadModel.setRegister(register);

            // Pass new model contents back up to view
            IntegerCalculatorValue newDisplay = keypadModel.getRegister();
            Timber.d("register value retrieved from keypadModel is %s", newDisplay);

            keypadView.setDisplay(newDisplay);
        } else if (key == KeypadKey.KEY_CLEAR_ALL) {
            keypadModel.clearAll();

            // Pass new model contents back up to view
            IntegerCalculatorValue newDisplay = keypadModel.getRegister();
            keypadView.setDisplay(newDisplay);
        } else if (key == KeypadKey.KEY_EQUALS) {
            // Do what?
        }
    }

    private long numericKeyToLong(KeypadKey key) {
        long result = 0L;

        switch (key) {
            case KEY_1:
                result = 1;
                break;
            case KEY_2:
                result = 2;
                break;
            case KEY_3:
                result = 3;
                break;
            case KEY_4:
                result = 4;
                break;

        }

        return result;
    }
}
