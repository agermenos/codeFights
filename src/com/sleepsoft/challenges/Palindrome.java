package com.sleepsoft.challenges;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by agermenos on 3/11/2017.
 */
public class Palindrome {

    private boolean isPalindrome(String subString) {
        int i = 0;
        int k = subString.length()-1;
        while (i<k) {
            if (subString.charAt(i)!=subString.charAt(k)) return false;
            i++; k--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        List<String> palindromeList = new ArrayList<>();
        for (int i=0;i<s.length();i++) {
            for (int k=s.length(); k>i;k--){
                if (isPalindrome(s.substring(i,k))) {
                    palindromeList.add(s.substring(i,k));
                    break;
                }
            }
        }
        Collections.sort(palindromeList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.length()-s1.length();
            }
        });
        if (palindromeList!=null && !palindromeList.isEmpty()) return palindromeList.get(0);
        else return "";
    }

    @Test
    public void testOne(){
        assertEquals("racecar", new Palindrome().longestPalindrome("thisisaracecar"));
    }
}


// t h i s i s a r a c  e  c  a  r
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13
// 3, 3
// 6, 3
// 7, 7