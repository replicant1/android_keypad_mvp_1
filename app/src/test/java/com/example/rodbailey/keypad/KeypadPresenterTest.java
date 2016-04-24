package com.example.rodbailey.keypad;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the KeypadPresenter, for which we need a mock model and a mock view
 */
public class KeypadPresenterTest {

    private boolean expectedMethodCalled;

    @Before
    public void beforeEachTest() {
        expectedMethodCalled = false;
    }

    @Test
    public void presenterPassesNumericKeyPressesOntoModel() {
        IKeypadModel mockModel = new IKeypadModel() {
            @Override
            public void appendToRegister(char value) {
                expectedMethodCalled = true;
                assertEquals('1', value);
            }

            @Override
            public void clearRegister() {

            }

            @Override
            public String getRegister() {
                return "";
            }
        };
        IKeypadView mockView = new MockKeypadView();
        IKeypadPresenter presenter = new KeypadPresenter(mockView, mockModel);
        presenter.keyPressed(KeypadKey.KEY_1);
        assertTrue(expectedMethodCalled);
    }

    @Test
    public void presenterPassesClearKeyPressOntoModel() {
        IKeypadModel mockModel = new IKeypadModel() {
            @Override
            public void appendToRegister(char value) {

            }

            @Override
            public void clearRegister() {
                expectedMethodCalled = true;
            }

            @Override
            public String getRegister() {
                return "";
            }
        };
        IKeypadView mockView = new MockKeypadView();
        IKeypadPresenter presenter = new KeypadPresenter(mockView, mockModel);
        presenter.keyPressed(KeypadKey.KEY_CLEAR);
        assertEquals("", mockModel.getRegister());
    }

    private class MockKeypadView implements IKeypadView {
        private String mockDisplay;

        @Override
        public void clearDisplay() {

        }

        @Override
        public void setDisplay(String display) {

        }
    }

    private class MockKeypadModel implements IKeypadModel {
        @Override
        public void clearRegister() {

        }

        @Override
        public String getRegister() {
            return "";
        }

        @Override
        public void appendToRegister(char value) {

        }
    }
}
