package com.sleepsoft.challenges.educative;

import java.util.HashMap;
import java.util.Map;

class NoRepeatSubstring {
    private static Map<String, Integer> letterMap = new HashMap<>();
    private static void flushMap(){
        letterMap = new HashMap<>();
    }

    private static boolean isRepeating(char letter) {
        int number = letterMap.getOrDefault(letter+"", 0);
        letterMap.put (letter+"", ++number);
        return number>1;
    }

    public static int findLength(String str) {
        // TODO: Write your code here
        flushMap();
        if (str==null || str.isEmpty()) return -1;
        int x = 0;
        int count = 0;
        int maxCount = 0;
        while (x<str.length()) {
            char letter = str.charAt(x);
            if (!isRepeating(letter)) count++;
            else {
                flushMap();
                maxCount = Math.max(maxCount, count);
                x--;
                count = 0;
            }
            x++;
        }
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}

/** DEBUG
 str: abbbb
 x: 2
 letter: b
 count: 1
 maxCount: 2
 */
