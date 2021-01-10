package com.sleepsoft.challenges.leetcode;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Integer[] newNums1 = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        Integer[] newNums2 = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
        List<Integer> myList = new ArrayList<>();
        myList.addAll(Arrays.asList(newNums1));
        myList.addAll(Arrays.asList(newNums2));
        Integer[] values = myList.stream().sorted().collect(Collectors.toList()).toArray(new Integer[myList.size()]);
        if (values.length%2 == 0) {
            int top = values[(values.length+1)/2];
            int bottom = values[(values.length-1)/2];
            return (float)(top+bottom)/2;
        }
        else return values[((values.length+1)/2)-1];
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        int[] nums1 = {1,1};
        int[] nums2 = {1,2};
        System.out.println ("Array 1: " + nums1);
        System.out.println("Array 2: " + nums2);
        System.out.println("Median: " + solution.findMedianSortedArrays(nums1, nums2));
    }
}