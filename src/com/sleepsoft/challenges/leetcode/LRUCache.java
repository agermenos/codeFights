package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class LRUCache {
    public Integer[] getLRU (int[] numbers, int size){
        Stack<Integer> myStack = new Stack<>();
        for (int value:numbers) {
            if (myStack.contains(value)){
                myStack.remove(Integer.valueOf(value));
            }
            else if (myStack.size()==size){
                myStack.remove(0);
            }
            myStack.push(value);
        }
        Integer[] returnArray = new Integer[size];
        for (int x=0;x<size;x++) returnArray[x]=myStack.get(size-1-x);
        return returnArray;
    }

    private void prepare(int[]sample, int size, int[]expected){
        System.out.printf("\n\tSample: %s\n\tSize: %d\n\tExpected: %s\n\tOutput: %s\n", Arrays.toString(sample), size,
                Arrays.toString(expected), Arrays.toString(getLRU(sample, size)));
    }

    @Test
    public void test(){
        prepare(new int[]{1, 2, 1, 2, 1, 4, 5, 4, 3, 2}, 3, new int[]{2,1,4});
        prepare(new int[]{1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5}, 3, new int[]{5, 2, 1});
    }
}
