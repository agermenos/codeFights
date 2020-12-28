package com.sleepsoft.challenges.leetcode;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int bestCount = 0;
        int currentCount = 0;
        Map<String, Integer> valueMap = new HashMap<>();
        for (int x = 0; x < s.length(); x++) {
            Integer nextValue = valueMap.get(s.charAt(x) + "");
            if (nextValue == null || nextValue == 0) {
                currentCount++;
                nextValue= 0;
            }
            else {
                bestCount = Math.max(bestCount, currentCount);
                currentCount = 1;
                valueMap = new HashMap<>();
            }
            valueMap.put(s.charAt(x) + "", ++nextValue);
        }
        if (currentCount!=0 && currentCount>bestCount) return currentCount;
        return bestCount;
    }

    @Test
    public void testLongestSubstring(){
        assert(lengthOfLongestSubstring("dvdf")==3);
    }
}