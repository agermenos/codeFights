package com.sleepsoft.challenges;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class DedupStrings{
    public static String[] dup(String[] arr){
        List<String>responseList = new ArrayList<>();
        Arrays.stream(arr).forEach(word -> {
            StringBuffer dt = new StringBuffer();
            dt.append(word.charAt(0)+"");
            for (int k=0;k<word.length()-1;k++){
                while (k<word.length()-2 && word.charAt(k)==word.charAt(k+1)) {
                    k++;
                }
                if (word.charAt(k)!=word.charAt(k+1)) dt.append(word.charAt(k+1)+"");
            }
            responseList.add(dt.toString());
        });
        return responseList.toArray(new String[responseList.size()]);
    }

    @Test
    public void basicTests(){
        assertArrayEquals(new String[]{"codewars","picaniny","hubububo"},DedupStrings.dup(new String[]{"ccooddddddewwwaaaaarrrrsssss","piccaninny","hubbubbubboo"}));
        assertArrayEquals(new String[]{"abracadabra","alote","asese"},DedupStrings.dup(new String[]{"abracadabra","allottee","assessee"}));
        assertArrayEquals(new String[]{"keles","kenes"},DedupStrings.dup(new String[]{"kelless","keenness"}));
    }
}