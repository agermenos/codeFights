package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.*;

/**
 * Created by agerm on 12/16/2016.
 */
public class MapOfWords {
    public Map<String, Integer> fileWordCount(String originalText){
        Map<String, Integer> resultMap = new HashMap<>();

        String cleanText = originalText.replaceAll("[.,;]+", "");
        String[] cleanTextArray = cleanText.split(" ");

        Arrays.stream(cleanTextArray).forEach(word->{
            Integer incidences=resultMap.get(word.toLowerCase());
            if (incidences==null){
                resultMap.put(word.toLowerCase(), 1);
            }
            else {
                resultMap.put(word.toLowerCase(), ++incidences);
            }
        });

        //This is the hard part!!
        Map<String, Integer> result = new LinkedHashMap<>();
        //sort by key, a,b,c..., and put it into the "result" map
        resultMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }

    @Test
    public void test_1(){
        String string= new String("This, is a test; we are using. a to the test the test");
        Map<String, Integer> result = fileWordCount(string);
        System.out.println(result);
    }
}
