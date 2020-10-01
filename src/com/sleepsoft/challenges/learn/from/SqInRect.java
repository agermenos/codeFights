package com.sleepsoft.challenges.learn.from;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class SqInRect {

    public static List<Integer> sqInRect(int lng, int wdth) {
        List <Integer>vals = new ArrayList<>();
        if (wdth==lng) {
           vals.add(1);
           return vals;
        }
        else if (wdth>lng) return sqInRect(wdth, lng);
        vals.add(wdth);
        vals.addAll(sqInRect(lng-wdth, wdth));
        return vals;
    }

    @Test
    public void testSqInRect(){
        System.out.println("5,3 = [3,2,1,1] : "+ sqInRect(5,3).toString());
    }
}