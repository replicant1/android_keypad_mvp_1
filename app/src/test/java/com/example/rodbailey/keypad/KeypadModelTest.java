package com.example.rodbailey.keypad;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class KeypadModelTest {

    private KeypadModel model;

    @Before
    public void createNewModel() {
        model = new KeypadModel();
    }

    @Test
    public void modelIsInitializedWithEmptyString() throws Exception {
        assertEquals(model.getRegister(), "");
    }

    @Test
    public void appendToEmptyModel() throws Exception {
        model.appendToRegister('5');
        assertEquals(model.getRegister(), "5");
    }

    @Test
    public void appendToNonEmptyModel() throws Exception {
        model.appendToRegister('1');
        model.appendToRegister('2');
        assertEquals(model.getRegister(), "12");
    }

    @Test
    public void clearEmptyModel() throws Exception {
        model.clearRegister();
        assertEquals(model.getRegister(), "");
    }

    @Test
    public void clearNonEmptyModel() throws Exception {
        model.appendToRegister('1');
        model.appendToRegister('2');
        model.clearRegister();
        assertEquals(model.getRegister(), "");
    }
}