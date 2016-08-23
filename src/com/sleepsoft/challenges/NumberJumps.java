package com.sleepsoft.challenges;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

/**
 * Created by agermenos on 8/22/16.
 */
public class NumberJumps extends BaseTest {
    int minJumpToReachEnd(int points) {
        int length=0; int k=0; int position=1;
        System.out.println("\n\tlen\t| pos\n\t-------------");
        System.out.println("\t" + length + "\t| " + position);
        while (position<points) {
            if (position+length + (length)*(length+1)/2 > points & length>1) length--;
            if (position+length + (length)*(length+1)/2 < points) length++;
            position = position + length;
            k++;
            System.out.println("\t" + length + "\t| " + position);
        }
        return k;
    }

    private int factorial(int x) {
        int fact=0;
        while (x>0) {
            fact+=x--;
        }
        return fact;
    }

    @Test
    public void test(){

        prepare(14,minJumpToReachEnd(14));
        prepare(12,minJumpToReachEnd(12));
        prepare(8,minJumpToReachEnd(8));
        prepare(6,minJumpToReachEnd(6));
        prepare(5,minJumpToReachEnd(5));

    }
}
