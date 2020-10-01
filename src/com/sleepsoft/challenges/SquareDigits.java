package com.sleepsoft.challenges;

import org.junit.Test;

public class SquareDigits {


    public int squareDigits(int n) {
        String stringValue = n + "";
        StringBuffer retValue = new StringBuffer();
        while (stringValue.length() > 0) {
            int value = Integer.valueOf(stringValue.charAt(0) + "");
            value = value * value;
            stringValue = stringValue.substring(1, stringValue.length());
            n = stringValue.isEmpty() ? 0 : Integer.valueOf(stringValue);
            retValue.append(value + "");
        }
        return Integer.valueOf(retValue.toString());
    }

    @Test
    public void testSqD() {
        SquareDigits squareDigit = new SquareDigits();
        System.out.println("9119=811181: " + squareDigit.squareDigits(9119));
        System.out.println("123=149:" + squareDigit.squareDigits(123));
        System.out.println("9870=8164490:" + squareDigit.squareDigits(9870));
    }

}
