package com.sleepsoft.challenges;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by agerm on 8/21/2016.
 */
public class SizeInBytes extends BaseTest {
    String ComputerUnitsToByte(int capacity, String unit) {
        BigInteger potency=(BigInteger.valueOf(1));
        int base=0;
        switch (unit) {
            case"KB": base=1; break;
            case"MB": base=2; break;
            case"G":  base=3; break;
            case"TB": base=4; break;
            case"P":  base=5;
        }
        for (int k=0;k<base; k++){
            potency = potency.multiply(BigInteger.valueOf(1024));
        }
        potency = potency.multiply(BigInteger.valueOf(capacity));
        return potency.toString();
    }

    public void preTest(int value, String unit, String expected){
        System.out.print("test: " + value + ", " + unit + "\t");
        prepare(ComputerUnitsToByte(value, unit), expected);
    }

    @Test
    public void test(){
        // preTest(3, 1);
        preTest(12, "KB", "12288");
    }
}
