package com.sleepsoft.challenges;

import java.util.*;

/**
 * Created by agermenos on 10/2/2016.
 */
/*
You're given an array of names, where each name is given as a string. Your task is to link these names into a chain, so that the ith name starts with the same letter the (i - 1)th name ends, and return this chain as a list.

All names should be used. It is guaranteed that each name starts with a unique letter. It is also guaranteed that there is only one solution.

Example

For

names = ["Raymond",  "Nora", "Daniel",
         "Louie", "Peter", "Esteban"]
the output should be

chainNames(names) = ["Peter", "Raymond", "Daniel",
                     "Louie", "Esteban", "Nora"]
Input/Output

[time limit] 3000ms (java)
[input] array.string names

Array of names, where each name starts with a unique letter.

Constraints:
1 ≤ names.length ≤ 15,
1 ≤ names[i].length ≤ 10.

[output] array.string

Array of chained names.
 */
public class NameChainer {
    String[] chainNames(String[] names) {
        List<String> nameList = new ArrayList<>();
        Map<Character, String> startMap = new HashMap<>();
        Map<Character, String> endMap = new HashMap<>();
        for (String name:names){
            startMap.put(name.toLowerCase().charAt(0), name);
            endMap.put(name.toLowerCase().charAt(name.length()-1), name);
        }
        String baseName = getBaseName(startMap, endMap);
        nameList.add(baseName);
        while (baseName!=null) {
            Character key = baseName.charAt(baseName.length()-1);
            baseName=startMap.get(key);
            if (baseName!=null) {
                nameList.add(baseName);
                startMap.remove(key);
            }
        }
        return Arrays.copyOf(nameList.toArray(), nameList.toArray().length, String[].class);
    }

    private String getBaseName(Map<Character, String> startMap, Map<Character, String> endMap) {
        for (Character letter:startMap.keySet()) {
            if (!endMap.containsKey(letter)) return startMap.get(letter);
        }
        return null;
    }

    public String display(String[]names){
        StringBuilder result=new StringBuilder();
        for (String name:names) {
            result.append("\t" + name);
        }
        return result.toString();
    }


}
