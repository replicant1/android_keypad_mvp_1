package com.example.rodbailey.keypad.pinservice;

import java.io.IOException;
import java.util.List;

/**
 * Provides a facade which higher levels use to access PIN number information.
 * This interface supports only read-only access to the database of PIN info.
 */
public interface IPinService {
    /**
     * @return All currently defined PIN records. May be empty but is never null.
     * @throws IOException
     */
    List<Pin> getAllPins() throws IOException;

    /**
     * @param numericCode Numeric code of the PIN record to be retrieved.
     * @return A Pin P such that P.numericCode.equals(numericCode), or null if no such Pin is
     * found in the databasE.
     * @throws IOException
     */
    Pin getPinByNumericCode(String numericCode) throws IOException;

}
