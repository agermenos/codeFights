package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CommonPrefix {

    public boolean match(String[] strs, String pattern){
        for (String str:strs){
            if (!str.startsWith(pattern)) return false;
        }
        return true;
    }
    public String longestCommonPrefix(String[] strs) {
        String returnString="";
        if (strs==null || strs.length==0) return "";
        for (int k=1; k<=strs[0].length() && match(strs, strs[0].substring(0,k)); k++){
            returnString = strs[0].substring(0,k);
        }
        return returnString;
    }

    private void testing(String[] sample, String expected){
        System.out.printf("Input: %s\nExpected: \"%s\"\nOutput: \"%s\"\n", Arrays.toString(sample),expected, longestCommonPrefix(sample));
    }

    @Test
    public void test(){
        String[] test = new String[]{"a"};
        testing(test, "a");
        test = new String[]{"flower","flow","flight"};
        testing (test, "fl");
        test = new String[]{""};
        testing(test, "");
    }
}