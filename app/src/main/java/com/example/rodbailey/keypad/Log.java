package com.example.rodbailey.keypad;

/**
 * Facade to logging facility, so you can switch Android's Log in and out
 */
public class Log {

    public static void log(String tag, String msg) {
        System.out.println(tag + ":" + msg);
    }

    public static void log(String msg) {
        System.out.println(msg);
    }
}
