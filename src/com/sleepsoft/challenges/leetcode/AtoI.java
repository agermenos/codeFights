package com.sleepsoft.challenges.leetcode;

import org.junit.jupiter.api.Test;

public class AtoI {
    public int myAtoi(String str) {
        int sign = 1;
        if (str.matches("[+-]?\\s*[+-]?[0-9]*\\.?[0-9]*")) {
            if (str.startsWith("\\D") && !str.startsWith("{+-}[1]")) return 0;
            str = str.replaceAll("\\s", "");
            str = str.replaceAll("[a-zA-Z]", "");
            if (str.startsWith("-")) {
                sign = -1;
                str = str.replaceAll("-", "");
            }
            if (str.length()>10) {
                int retVal = sign>1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                return retVal;
            }
            return Integer.valueOf(str)*sign;
        }
        return 0;
    }

    @Test
    public void testAtoI(){
        AtoI atoI = new AtoI();
        System.out.printf("Parsing \"3.14159\" Result: %d\n" , atoI.myAtoi("3.14159"));
//        System.out.printf("Parsing \"-91283472332\" Result: %d\n" , atoI.myAtoi("-91283472332"));
//        System.out.printf("Parsing \"42\" Result: %d\n" , atoI.myAtoi("42"));
        System.out.printf("Parsing \"   -42\" Result: %d\n" ,atoI.myAtoi("       -42"));
        System.out.printf("Parsing \"4193 with words\" Result: %d\n" , atoI.myAtoi("4193 with words"));
        System.out.printf("Parsing \"words and 987\" Result: %d\n" , atoI.myAtoi("words and 987"));
    }
}
