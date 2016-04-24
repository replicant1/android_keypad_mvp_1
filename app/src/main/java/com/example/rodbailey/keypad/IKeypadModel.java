package com.example.rodbailey.keypad;

/**
 * Created by rodbailey on 24/04/2016.
 */
public interface IKeypadModel {

    public void appendToRegister(char value);

    public void clearRegister();

    public String getRegister();

    public interface IKeypadModelResultHandler {
        public void onResult(Object result);
    }
}
