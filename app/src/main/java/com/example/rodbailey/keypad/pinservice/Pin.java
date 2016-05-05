package com.example.rodbailey.keypad.pinservice;

import io.realm.RealmObject;

/**
 * Represents the PIN (numeric code) for a particular person's account or apartment.
 */
public class Pin extends RealmObject {
    /**
     * String of digit characters of unprescribed length
     */
    private String numericCode;

    /**
     * Name of the owner of the PIN-protected thing
     */
    private String name;

    /**
     * Primary key of the Pin record
     */
    private long id;

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("id=%d,name=%s,numericCode=%s", id, name, numericCode);
    }
}
