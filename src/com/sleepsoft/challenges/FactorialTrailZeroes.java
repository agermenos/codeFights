package com.sleepsoft.challenges;

import org.junit.jupiter.api.Test;


public class FactorialTrailZeroes {
    public static int zeros(int n) {
        int count = 0;
        for (int i = 5; (n/i) > 0; i=i*5) {
            count = count + n/i;
        }
        return count;
    }

    @Test
    public void testZeros() throws Exception {
//        assertThat(zeros(0), is(0));
//        assertThat(zeros(6), is(1));
//        assertThat(zeros(14), is(2));
//        assertThat(zeros(Integer.MAX_VALUE), is(536870902));
    }
}
