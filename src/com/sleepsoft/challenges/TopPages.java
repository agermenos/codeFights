package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class TopPages {
    public Integer[] getTopPages(int[] pages, int n){
        Stack<Integer> topStack = new Stack<>();
        for (int k:pages){
            if (topStack.size()==n){
                if (topStack.contains(Integer.valueOf(k))){
                    topStack.remove(Integer.valueOf(k));
                }
                else topStack.remove(0);
            }
            else if (topStack.contains(Integer.valueOf(k))) topStack.remove(Integer.valueOf(k));
            topStack.push(k);
        }

        return topStack.toArray(new Integer[]{});
    }

    private void prepare(int[] data, int n, int[]ideal){
        System.out.printf("\n\tInput: %s, n=%d\n\tExpected:%s\n\tOutput:%s\n", Arrays.toString(data), n, Arrays.toString(ideal), Arrays.toString(getTopPages(data, n)));
    }
    @Test
    public void testTopPages(){
        prepare(new int[]{1,2,1,3,4,5,1,2,3,2,2,1,3,4,1}, 4, new int[]{1, 4, 3});
        prepare(new int[]{1,2,1,2,3,4,5,5,1}, 2, new int[]{1,5});
    }
}
