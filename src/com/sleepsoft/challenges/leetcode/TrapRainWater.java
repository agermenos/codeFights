package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

public class TrapRainWater {

    private int getRelativeHeight(int[] height, int index) {
        if (index == 0) return 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int k = index-1; k >= 0; k--) {
            maxLeft = Math.max(maxLeft, height[k]);
        }
        for (int k = index+1; k < height.length; k++) {
            maxRight = Math.max(maxRight, height[k]);
        }
        int currentHeight = Math.min(maxLeft, maxRight) - height[index];
        if (currentHeight > 0) return currentHeight;
        else return 0;
    }

    public int trap(int[] height) {
        int wata = 0;
        for (int k = 0; k < height.length; k++) {
            wata = wata + getRelativeHeight(height, k);
        }
        return wata;
    }

    @Test
    public void test(){

        //System.out.printf("\n\tTesting with [0,1,0,2,1,0,1,3,2,1,2,1]\n\tExpected: 6\n\tOutput: %d\n", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.printf("\n\tTesting with [4,2,0,3,2,5]\n\tExpected: 9\n\tOutput: %d\n", trap(new int[]{4,2,0,3,2,5}));

    }
}
