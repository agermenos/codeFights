package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MorseValues {
    public int uniqueMorseRepresentations(String[] words) {
        String map[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String, Integer> wordUsage = new HashMap<>();
        for (String word:words) {
            StringBuilder morseWord = new StringBuilder();
            for (char c:word.toLowerCase().toCharArray()){
                int value = c;
                morseWord.append(map[(c-97)]);
            }
            int usage = wordUsage.get(morseWord.toString())!=null?wordUsage.get(morseWord.toString()):0;
            usage++;
            wordUsage.put(morseWord.toString(), usage);
        }
        return (wordUsage.size());
    }

    @Test
    public void testMorseValues(){
        System.out.printf("Testing values [\"yxmine\",\"yxzd\",\"eljys\",\"uiaopi\",\"pwlk\"], Expected: 3, Output: %d\n", uniqueMorseRepresentations(new String[]{"yxmine","yxzd","eljys","uiaopi","pwlk"}));
    }
}
