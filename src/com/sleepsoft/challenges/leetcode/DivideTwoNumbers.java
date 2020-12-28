package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        int sign =1;
        if ((dividend>0 && divisor<0)||(dividend<0&&divisor>0)||(dividend<0&&divisor<0)) {
            if ((dividend>0 && divisor<0)||(dividend<0&&divisor>0)) sign = -1;
            dividend = dividend>0?dividend:dividend*-1;
            divisor = divisor>0?divisor:divisor*-1;
            if (dividend==-2147483648) dividend=2147483647;
            if (divisor==-2147483648) divisor=2147483647;
        }
        int count=0;
        while (dividend>=divisor) {
            dividend = dividend - divisor;
            count++;
        }
        Arrays.stream(new int[]{}).boxed().sorted().collect(Collectors.toList());
        return count*sign;
    }

    private void preTest(int n1, int n2, int expected){
        System.out.printf("\n\tTest\n\t%d\n\t%d\n\tExpected:%d\n\tOutput:%d\n", n1, n2, expected, divide(n1, n2));
    }

    @Test
    public void test(){
       int n1 = -1;
       int n2 = -1;
       preTest(-1,-1, 1);
       n1 =-2147483648;
       n2 =-1;
       preTest(n1, n2, 2147483647);
    }
}