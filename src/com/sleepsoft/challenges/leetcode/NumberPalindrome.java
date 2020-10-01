package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

public class NumberPalindrome {
    public boolean isPalindrome(int x) {
        int palVal =0;
        int cloneX = x;
        if (x<0) return false;
        while (x>0) {
            palVal = x%10 + (palVal*10);
            x=x/10;
        }
        return cloneX ==palVal;
    }

    @Test
    public void testPal(){
        NumberPalindrome np = new NumberPalindrome();
        System.out.printf("121: Expected: true: Result: %b\n", np.isPalindrome(121));
    }
}