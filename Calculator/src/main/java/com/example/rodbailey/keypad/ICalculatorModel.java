package com.example.rodbailey.keypad;

/**
 * Contains all the state information for a calculator
 */
public interface ICalculatorModel {

    public void appendToRegister(char value);

    public void clearRegister();

    public String getRegister();
}
