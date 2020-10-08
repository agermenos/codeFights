package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

public class Probability {
    public int numRollsToTarget(int d, int f, int target) {
        int counter=0;
        int complexity = d;

        int map[] = new int[f];
        for (int x = 0; x < f; x++) map[x] = x + 1;
        while (complexity > 1) {
            map = transformToArray(map, f);
            complexity--;
        }

        for (int x = 0; x < map.length; x++) {
            if (map[x] == target) counter++;
        }

        return counter;
    }

    private int[] transformToArray(int[] map, int f) {
        int squareMap[][]=new int[map.length][f];
        for (int x=0;x<map.length;x++){
            for (int y=0;y<f;y++) {
                squareMap[x][y] = map[x]+y+1;
            }
        }
        int[] returnArray=new int[map.length*f];
        int x=0;
        int y=0;
        for (int cont=0;cont<returnArray.length;cont++){
            returnArray[cont]=squareMap[x++][y];
            if (x==squareMap.length){
                x=0;
                y++;
            }
        }
        return returnArray;
    }

    @Test
    public void testProbability(){
        Probability probability=new Probability();
        System.out.printf("Testing for 7 on 2 dices of 6 faces: Expected 6: Output:%d\n",probability.numRollsToTarget(2,6,7));
        System.out.printf("Testing for 3 on 1 dices of 6 faces: Expected 1: Output:%d\n",probability.numRollsToTarget(1,6,3));
        System.out.printf("Testing for 10 on 2 dices of 5 faces: Expected 1: Output:%d\n",probability.numRollsToTarget(2,5,10));
        System.out.printf("Testing for 3 on 1 dices of 2 faces: Expected 0: Output:%d\n",probability.numRollsToTarget(1,2,3));
        System.out.printf("Testing for 500 on 30 dices of 30 faces: Expected 0: Output:%d\n",probability.numRollsToTarget(30,30,500));
    }
}
