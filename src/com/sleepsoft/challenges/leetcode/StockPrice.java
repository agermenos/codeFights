package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

public class StockPrice {
    public int maxProfitTotal(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            int diff = prices[i]-prices[i-1];
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }
    public int maxProfitOnce(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int min=prices[0]; // min so far
        int result=0;
        for(int i=1; i<prices.length; i++){
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }
    @Test
    public void testProfit(){
        System.out.printf("\n\tTesting with [-5,10,15,-2,1,8,0,6,13]\n\tmaxProfitOnce Expected: 20 Output:%d\n\tmaxProfitTotalExpected: 43 Output: %d\n", maxProfitOnce(new int[]{-5,10,15,-2,1,8,0,6,13}), maxProfitTotal(new int[]{-5,10,15,-2,1,8,0,6,13}));

    }
}
