package com.example.rodbailey.keypad;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import static com.example.rodbailey.keypad.KeypadKey.KEY_1;
import static com.example.rodbailey.keypad.KeypadKey.KEY_2;
import static com.example.rodbailey.keypad.KeypadKey.KEY_3;
import static com.example.rodbailey.keypad.KeypadKey.KEY_4;
import static com.example.rodbailey.keypad.KeypadKey.KEY_5;
import static com.example.rodbailey.keypad.KeypadKey.KEY_6;
import static com.example.rodbailey.keypad.KeypadKey.KEY_7;
import static com.example.rodbailey.keypad.KeypadKey.KEY_8;
import static com.example.rodbailey.keypad.KeypadKey.KEY_9;
import static com.example.rodbailey.keypad.KeypadKey.KEY_CLEAR;
import static com.example.rodbailey.keypad.KeypadKey.KEY_OK;


/**
 * View of the keypad. This is a *passive* view - it does nothing itself, it contains no logic of its own.
 */
public class CalculatorView extends Fragment implements ICalculatorView {

    private static final String TAG = CalculatorView.class.getSimpleName();
    private TextView display;
    private Map<Button, KeypadKey> keys = new HashMap<Button, KeypadKey>();
    private KeypadClickListener keypadClickListener = new KeypadClickListener();
    private final ICalculatorPresenter keypadPresenter;

    /**
     * Fragments must have a public empty constructor
     */
    public CalculatorView() {
        keypadPresenter = new CalculatorPresenter(this, new CalculatorModel());
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CalculatorView.
     */
    public static CalculatorView newInstance() {
        CalculatorView fragment = new CalculatorView();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.keypad_view, container, false);

        Log.d(TAG, "Into onCreateView");

        // The output display at the top of the keypad
        display = (TextView) fragmentView.findViewById(R.id.keypad_display);

        Log.d(TAG, "R.id.keypad_display is bound to widget " + display);

        // Each key in the keypad is in the 'keys' array, so we can identify symbolically which
        // button is clicked on.
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_1), KEY_1);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_2), KEY_2);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_3), KEY_3);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_4), KEY_4);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_5), KEY_5);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_6), KEY_6);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_7), KEY_7);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_8), KEY_8);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_9), KEY_9);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_clear), KEY_CLEAR);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_ok), KEY_OK);

        for (Button button : keys.keySet()) {
            button.setOnClickListener(keypadClickListener);
        }

        Log.d(TAG, "Exiting onCreateView");

        return fragmentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setDisplay(String display) {
        this.display.setText(display);
    }

    @Override
    public void clearDisplay() {
        display.setText("");
    }

    private class KeypadClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            KeypadKey keyClicked = keys.get(view);
            keypadPresenter.keyPressed(keyClicked);
        }
    }
}
