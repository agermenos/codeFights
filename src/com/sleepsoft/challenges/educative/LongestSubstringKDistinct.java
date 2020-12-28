package com.sleepsoft.challenges.educative;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestSubstringKDistinct {
    private static int countDistinctChars(String str){
        Map<String, Integer> letterCounter = new HashMap<>();
        for(char c:str.toCharArray()){
            Integer value = letterCounter.get(c+"");
            if (value==null) {
                letterCounter.put(c+"", 1);
            }
            else {
                letterCounter.put(c+"", value+1);
            }
        }
        return letterCounter.keySet().size();
    }

    public static int findLength(String str, int k) {
        // TODO: Write your code here
        int i = 0; //left window corner
        int currentCount = 0;
        int maxCount = 0;
        while (i<str.length() && currentCount<k){
            int j=i+1;
            String currentString = str.substring(i,j);
            currentCount = countDistinctChars(currentString);
            while (currentCount <= k && j<str.length()) {
                currentString = str.substring(i, ++j);
                currentCount = countDistinctChars(currentString);
            }
            if (i<str.length()) {
                maxCount = Math.max(maxCount, currentString.length()-1);
            }
            i++;
        }
        return maxCount;
    }
    @Test
    public void test(){
        System.out.printf("\n\tInput: findLength(araaci, 2)\n\tExpected %d:\n\tOutput: %d\n\n",2, findLength("araaci", 2));
    }
}