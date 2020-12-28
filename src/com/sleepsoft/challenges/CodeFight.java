package com.sleepsoft.challenges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by agermenos on 12/12/16.
 */
public class CodeFight {
    Object[] testFight(int n) {
        List<String> strArr = new ArrayList<>(n);
        for (int k=1;k<=n; k++){
            if (k<5) strArr.add(k+"");
            else if ((k%7==0) && (k%5==0))
                strArr.add("CodeFight");
            else if (k%7==0) strArr.add("Fight");
            else if (k%5==0) strArr.add("Code");
            else strArr.add(k+"");
        }
        return  strArr.toArray();
    }

    @Test
    public void test(){
        prepare (1, new String[] {"1"});
        prepare (2, new String[] {"1", "2"});

    }

    private void prepare(int n, String[] strings) {
        System.out.println("Calling for n = " + n);
        System.out.println(Arrays.toString(testFight(n)));
        assertEquals(strings, testFight(n));
    }
}
