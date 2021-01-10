package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Anagrams {

    private void prepare(String firstString, String secondString, boolean isAnagram){
        System.out.printf("\n\tValue: \"%s\" and \"%s\"\n\tExpected: %s\n\tOutput: %s\n", firstString, secondString, isAnagram, isAnagram(firstString, secondString));
    }

    private Map<String, Integer> loadMap(String text){
        text = text.toLowerCase(Locale.ROOT);
        Map<String, Integer> returnMap= new HashMap<>();
        for (char c: text.toCharArray()){
            if (c!=' ')
                returnMap.put(c+"", returnMap.getOrDefault(c+"",0)+1);
        }
        return returnMap;
    }

    public boolean isAnagram(String firstString, String secondString) {
        Map<String, Integer> firstMap = loadMap(firstString);
        Map<String, Integer> secondMap = loadMap(secondString);
        return firstMap.equals(secondMap);
    }

    @Test
    public void testPalindrome(){
        prepare("abcdeefsfds", "dec", false);
        prepare("rac", "carddflkdjasflk", false);
        prepare("Dormitory", "Dirty room", true);
        prepare ("Conversation", "Voices rant on", true);
    }
}
