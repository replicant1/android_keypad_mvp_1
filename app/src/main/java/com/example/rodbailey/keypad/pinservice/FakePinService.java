package com.example.rodbailey.keypad.pinservice;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Fake implementation of the IPinService. Database of PINs is seeded with some hard coded PINs
 * that are stored in memory.
 */
public class FakePinService implements IPinService {

    Set<Pin> fakePins = new HashSet<Pin>();

    public FakePinService() {
//        fakePins.add(new Pin("1234", "John Smith"));
    }


    @Override
    public Set<Pin> getAllPins() throws IOException {
        return null;
    }

    @Override
    public Pin getPinByNumericCode(String numericCode) throws IOException {
        return null;
    }
}
