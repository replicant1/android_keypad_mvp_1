package com.example.rodbailey.keypad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rodbailey.keypad.util.Log;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import timber.log.Timber;

import static com.example.rodbailey.keypad.KeypadKey.KEY_1;
import static com.example.rodbailey.keypad.KeypadKey.KEY_2;
import static com.example.rodbailey.keypad.KeypadKey.KEY_3;
import static com.example.rodbailey.keypad.KeypadKey.KEY_4;
import static com.example.rodbailey.keypad.KeypadKey.KEY_CLEAR_ALL;
import static com.example.rodbailey.keypad.KeypadKey.KEY_EQUALS;
import static com.example.rodbailey.keypad.KeypadKey.KEY_MINUS;
import static com.example.rodbailey.keypad.KeypadKey.KEY_PLUS;


/**
 * View of the keypad. This is a *passive* view - it does nothing itself, it contains no logic of its own.
 * It simply presents an LCD numeric display at top and a keypad underneath that contains the
 * digits 1 - 9
 */
public class CalculatorFragment extends Fragment implements ICalculatorView {

    private static final String TAG = CalculatorFragment.class.getSimpleName();

    private final Map<Button, KeypadKey> keys = new HashMap<Button, KeypadKey>();

    private final KeypadClickListener keypadClickListener = new KeypadClickListener();

    private final ICalculatorPresenter keypadPresenter;

    /**
     * The output display at the top of the keypad
     */
    @BindView(R.id.keypad_display)
    TextView display;

    /**
     * Fragments must have a public empty constructor
     */
    public CalculatorFragment() {
        keypadPresenter = new CalculatorPresenter(this, new CalculatorModel());
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CalculatorFragment.
     */
    public static CalculatorFragment newInstance() {
        CalculatorFragment fragment = new CalculatorFragment();
        return fragment;
    }

    @Override
    public void clearDisplay() {

    }

    @Override
    public void flashDisplay() {
        Timber.e("flashDisplay() not implemented yet");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @DebugLog
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.keypad_view, container, false);

        ButterKnife.bind(this, fragmentView);

        // Each key in the keypad is in the 'keys' array, so we can identify symbolically which
        // button is clicked on.
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_1), KEY_1);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_2), KEY_2);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_3), KEY_3);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_4), KEY_4);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_plus), KEY_PLUS);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_minus), KEY_MINUS);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_clear), KEY_CLEAR_ALL);
        keys.put((Button) fragmentView.findViewById(R.id.keypad_button_equals), KEY_EQUALS);

        for (Button button : keys.keySet()) {
            button.setOnClickListener(keypadClickListener);
        }

        return fragmentView;
    }

    @DebugLog
    @Override
    public void setDisplay(IntegerCalculatorValue display) {
        this.display.setText(display.getValueAsString());
    }

    private class KeypadClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            KeypadKey keyClicked = keys.get(view);
            keypadPresenter.keyPressed(keyClicked);
        }
    }
}
