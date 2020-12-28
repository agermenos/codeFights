package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numberMap.get(complement) != null && numberMap.get(complement) != i) return
                    new int[]{i, numberMap.get(complement)};
            numberMap.put(nums[i], i);
        }
        return new int[]{};
    }

    @Test
    public void testTwoNumbers() {
        System.out.printf("Testing with [1,8,5,3], target 6.\nExpected: [0, 2].\nOutput: %s\n", Arrays.toString(twoSum(new int[]{1,8,5,3}, 6)));
    }
}
