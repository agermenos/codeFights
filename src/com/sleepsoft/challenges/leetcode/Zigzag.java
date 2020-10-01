package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zigzag {
    public String convert(String s, int numRows) {
        List<StringBuilder> stringList = new ArrayList<>(numRows);
        for (int i=0;i<numRows;i++) stringList.add(new StringBuilder());
        boolean goingDown=true;
        int yPos =0;
        while (s!=null && s.length()>0) {
            String letter = s.charAt(0)+"";
            if (s.length()>1)
                s = s.substring(1);
            else s=null;
            if (goingDown && yPos< numRows) {
                stringList.get(yPos++).append(letter);
            }
            else if (!goingDown && yPos>0) {
                stringList.get(yPos--).append(letter);
            }
            else stringList.get(0).append(letter);
            if (goingDown && yPos ==numRows-1) {
                goingDown=false;
            }
            if (!goingDown && yPos==0){
                goingDown=true;
            }
        }
        return stringList.stream().collect(Collectors.joining()).toString();
    }

    @Test
    public void testZigZag(){
        Zigzag zigzag = new Zigzag();
        String result = zigzag.convert("PAYPALISHIRING", 3);
        System.out.println ("Input: s = \"PAHNAPLSIIGYIR\", numRows = 3, Expected \"PAHNAPLSIIGYIR\"");
        System.out.println("Output: " + result);
        result = zigzag.convert("PAYPALISHIRING", 4);
        System.out.println ("Input: s = \"PAYPALISHIRING\", numRows = 4, Expected \"PINALSIGYAHRPI\"");
        System.out.println("Output: " + result);
        result = zigzag.convert("", 1);
        System.out.println ("Input: s = \"\", numRows = 1, Expected \"\"");
        System.out.println("Output: " + result);
        result = zigzag.convert("AB", 1);
        System.out.println ("Input: s = \"AB\", numRows = 1, Expected \"AB\"");
        System.out.println("Output: " + result);
    }
}
