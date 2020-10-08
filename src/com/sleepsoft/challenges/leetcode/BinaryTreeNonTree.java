package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

public class BinaryTreeNonTree {
    public static String solution(long[] arr) {
        if (arr==null || arr.length==0) return "";
        int fatArrow=1;
        int jump=1;
        boolean isLeft=true;
        long leftValue=0;
        long rightValue=0;
        while (fatArrow<arr.length){
            int steps=0;
            for(int k=fatArrow;k<fatArrow+jump && k<arr.length;k++){
                if (isLeft) leftValue=leftValue+(arr[k]==-1?0:arr[k]);
                else rightValue=rightValue+(arr[k]==-1?0:arr[k]);
                steps++;
            }
            if (!isLeft){
                jump = jump*2;
                isLeft=true;
            }
            else isLeft=false;
            fatArrow=fatArrow+steps;
        }
        if (leftValue>rightValue) return "Left";
        if (rightValue>leftValue) return "Right";
        return "";
    }
    @Test
    public void testSolution(){
        System.out.printf("Input [3,6,2,9,-1,10] Output: %s\n", solution(new long[]{3,6,2,9,-1,10}));
    }
}
