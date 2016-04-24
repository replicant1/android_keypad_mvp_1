package com.example.rodbailey.keypad;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test the KeypadPresenter, for which we need a mock model and a mock view
 */
public class KeypadPresenterTest {

    @Test
    public void presenterPassesNumericKeyPressesOntoModel() {
        IKeypadModel mockModel = Mockito.mock(IKeypadModel.class);
        IKeypadView mockView = Mockito.mock(IKeypadView.class);
        IKeypadPresenter presenter = new KeypadPresenter(mockView, mockModel);

        // When the model.getRegister() is called, return "1"
        Mockito.when(mockModel.getRegister()).thenReturn("1");
        presenter.keyPressed(KeypadKey.KEY_1);

        // Verify that presenter called mockModel.appendToRegister('1');
        Mockito.verify(mockModel).appendToRegister('1');

        // Verify that presenter called mockView.setDisplay("1");
        Mockito.verify(mockView).setDisplay("1");
    }

    @Test
    public void presenterPassesClearKeyPressOntoModel() {
        IKeypadModel mockModel = Mockito.mock(IKeypadModel.class);
        IKeypadView mockView = Mockito.mock(IKeypadView.class);
        IKeypadPresenter presenter = new KeypadPresenter(mockView, mockModel);
        presenter.keyPressed(KeypadKey.KEY_CLEAR);

        // Verify that presenter called mockModel.clearRegister()
        Mockito.verify(mockModel).clearRegister();

        // Verify that presenter called mockView.clearDisplay();
        Mockito.verify(mockView).clearDisplay();
    }


}
