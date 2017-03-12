package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by agermenos on 3/11/2017.
 */
public class Palyndrome {

    public boolean check(char[] subText, int from, int to){
        if (to>=from) return subText[from]==subText[to];
        if (subText[from]==subText[to]){
            return check(subText, from+1, to-1);
        }
        else return false;
    }

    public String checkPalyndrome(String text) {
        char chrText[] = text.toCharArray();
        Map<Integer, Integer> palyndromeMap = new HashMap<>();
        for (int i=0; i<text.length()-2;i++){
            for (int k=chrText.length-1; k>i; k--){
                if (check(chrText, i, k)) {
                    palyndromeMap.put(i, k-i+1);
                    break;
                }
            }
        }
        Map.Entry<Integer, Integer> position = palyndromeMap.entrySet().
                stream().
                sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).findFirst().get();
        return text.substring(position.getKey(), position.getKey()+position.getValue());
    }

    @Test
    public void testOne(){
        assertEquals("araceca", new Palyndrome().checkPalyndrome("thisisaracecar"));
    }
}


// t h i s i s a r a c  e  c  a  r
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13
// 3, 3
// 6, 3
// 7, 7