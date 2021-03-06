package com.sleepsoft.challenges.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.
 *
 * You can move according to the next rules:
 *
 * In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
 * You have to visit the points in the same order as they appear in the array.
 *
 *
 * Example 1:
 *
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 *
 *  Example 2:
 *
 * Input: points = [[3,2],[-2,2]]
 * Output: 5
 */
class FaceBookOne {
    private int distance(int[][] points) {
        return Math.max(Math.abs(points[1][0]-points[0][0]),Math.abs(points[1][1]-points[0][1]));
    }
    public int minTimeToVisitAllPoints(int[][] points) {
       // List<Integer> distances = Arrays.
//                stream(points[][]).
//                sort((int point1[], int point2[]) -> Math.max(Math.abs(point2[0] - point1[0]), Math.abs(point2[1]-point1[1]))).
//        collect(Collectors.toList());
//        return distances.stream().skip(0).mapToInt(distance)
        return 0;
    }
}
