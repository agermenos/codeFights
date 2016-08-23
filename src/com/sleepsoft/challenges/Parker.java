package com.sleepsoft.challenges;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

/**
 * Created by agermenos on 8/22/16.
 */
public class Parker extends BaseTest {
    boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        return (fits(carDimensions, luckySpot) && spotIsEmpty(parkingLot, luckySpot) && canPark(carDimensions, parkingLot, luckySpot));
    }

    private boolean fits(int[] carDimensions, int[] luckySpot) {
        if ((carDimensions[0]>luckySpot[3]-luckySpot[1]-1)
            && (carDimensions[1]<=luckySpot[2]-luckySpot[0]+1))
        return true;
        else return false;
    }

    private boolean canPark(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        int reqY = (luckySpot[2]-luckySpot[0]+1>carDimensions[1]?luckySpot[2]-luckySpot[0]:carDimensions[1]);
        for (int yLane=0; yLane<=reqY; yLane++) {
            boolean try_lane=true;
            for (int poy = luckySpot[0] + yLane; poy <= yLane + reqY; poy++) {
                int lane[]=parkingLot[poy];
                for (int x=0; x<luckySpot[3]; x++){
                    if (lane[x]==1) try_lane=false;
                }
            }
            if (try_lane) return true;
        }
        return false;
    }

    private boolean spotIsEmpty(int[][] parkingLot, int[] luckySpot) {
        for (int x =luckySpot[1]; x<luckySpot[3]; x++) {
            for (int y = luckySpot[0]; y<luckySpot[2]; y++){
                if (parkingLot[y][x]==1) return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        prepare("Test 1\t", parkingSpot(new int[]{5, 3}, new int[][]{{1,1,1,1,1,0,1,1,1,1},
                                                                     {0,1,0,0,1,0,0,0,0,0}, 
                                                                     {0,0,0,0,0,0,0,0,1,0}, 
                                                                     {0,0,0,0,0,0,0,0,0,0}, 
                                                                     {0,0,0,0,0,0,0,0,0,1}, 
                                                                     {0,0,0,0,0,0,0,0,1,0}, 
                                                                     {0,0,1,0,0,0,0,0,0,0}, 
                                                                     {1,0,0,0,0,0,0,0,0,0}}, 
                                                            new int[]{1, 3, 5, 5}));
    }


}
