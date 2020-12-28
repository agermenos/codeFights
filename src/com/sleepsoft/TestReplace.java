package com.sleepsoft;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by agermenos on 11/10/16.
 */
public class TestReplace {
    public void prepare(String expected, String result){
        System.out.println("Expected: " + expected + "\nResult: " + result);
        assertTrue (expected.equals(result));
    }

    @Test
    public void test1(){
        prepare(".jpg", ".png".replace("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)", ".jpg"));
    }
}
