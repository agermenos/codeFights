package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class TrappingRainWater {                    // 0 1 2 3 4 5 6 7 8 9 10 11
    public int trap(int[] height) {
        if (height==null || height.length<=1) return 0;
        int wata =0;
        int from =0;
        int to;
        while (from<height.length-1 && height[from]==0) height[from] = height[from++];
        for (;from<=height.length-1;from++){
            to=from+1;
            while ((to<height.length-1) && (height[from]>=height[to])){
                to++;
            }
            if (to>from && to<height.length-1){
                for (int k=from;k<to;k++) {
                    wata = wata + Math.max(Math.min(height[from],height[to]) - height[k],0);
                }
                from = to-1;
            }
        }
        return wata;
    }

    @Test
    public void test(){
        System.out.printf("\tInput: [0,1,0,2,1,0,1,3,2,1,2,1] \n\tExpected: 6\n\tOutput: %d\n", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.printf("\tInput: [0] \n\tExpected: 0\n\tOutput: %d\n", trap(new int[]{0}));
    }
}
