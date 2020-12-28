package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

public class Stock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices != null && prices.length > 1) {
            for (int past = 0; past < prices.length - 1; past++)
                for (int future = past + 1; future < prices.length; future++) {
                    if (prices[past] < prices[future]) {
                        profit = profit + (prices[future] - prices[past]);
                        past = future+1;
                    }
                }
        }
        return profit;
    }

    @Test
    public void testProfits(){
        System.out.printf("Testing [7,1,5,3,6,4] Expected: 7  Output: %d\n", maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
