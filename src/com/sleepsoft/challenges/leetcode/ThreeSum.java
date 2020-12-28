package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer>numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<List<Integer>> returnValues = new HashSet<>();
        for (int k=0;k<nums.length-2;k++) {
            for (int l=k+1;l<nums.length-1;l++) {
                List<Integer> copyList = numList;
                copyList.remove(k);
                copyList.remove(l);
                int c = -nums[k]-nums[l];
                if (copyList.contains(c)) {
                    List<Integer> set = new ArrayList<>();
                    set.add(nums[k]);
                    set.add(nums[l]);
                    set.add(c);
                    Collections.sort(set);
                    returnValues.add (new ArrayList(set));
                }
            }
        }
        return new ArrayList(returnValues);
    }
    private void prepare(int[]sample, List<List<Integer>> expected){

    }

    @Test
    public void test(){
        int[] sample = new int[]{-1,0,1,2,-1,-4};
        //List<List<Integer>> expected =
    }
}
