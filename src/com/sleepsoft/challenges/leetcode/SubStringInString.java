package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

public class SubStringInString {
    public String getMaxSubString(String one, String two){
        char[] cOne=one.toCharArray();
        char[] cTwo = two.toCharArray();
        String max="";
        for (int k=0;k<cOne.length;k++){
            for (int l=0;l<cTwo.length;l++){
                if (cOne[k]==cTwo[l]){
                   StringBuilder result = new StringBuilder();
                   while ((k<cOne.length && l<cTwo.length) && cOne[k]==cTwo[l]){
                       result.append(cOne[k++]);
                       l++;
                   }
                   if (result.length()>max.length()) max = result.toString();
                }
            }
        }
        return max;
    }

    @Test
    public void testSubStrings(){
        String str1="OldSite:GeeksforGeeks.org";
        String str2="NewSite:GeeksQuiz.com";

        System.out.println("String 1: "+str1);
        System.out.println("String 2: "+str2);
        System.out.println("Longest common subString is: " +getMaxSubString(str1, str2));
    }
}
