package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

public class RecursiveInvertCharArray {

    public char[] reverseString(char[] s) {
        if (s.length != 0) return helper(s, s.length-1).toCharArray();
        return new char[0];
    }

    public String helper(char[] c, int end) {
        if (end>=0) return ((c[end]) + (end > 0 ? helper(c, end-1) : ""));
        else return"";
    }

    @Test
    public void testRecursiveInvertCharArray(){
        System.out.printf("Input: {'h','e','l','l','o'} Expected:{'o','l','l','e','h'} Output:%s\n", new String(reverseString(new char[]{'h','e','l','l','o'})));
    }

}
