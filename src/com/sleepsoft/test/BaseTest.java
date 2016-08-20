package com.sleepsoft.test;

/**
 * Created by agermenos on 8/19/16.
 */
public class BaseTest {
    public void log(String message){
        System.out.println(message);
    }
    public void prepare (int value, int expected){
        log("received: " + value + "\t expected: " + expected);
    }
}
