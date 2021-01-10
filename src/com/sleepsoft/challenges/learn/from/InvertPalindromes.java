package com.sleepsoft.challenges.learn.from;

import org.junit.jupiter.api.Test;

public class InvertPalindromes {
    private boolean isPalindrome(int number){
        String strNumber = number+"";
        int leftChar = strNumber.length() - 1;
        int rightChar = 0;
        boolean isPalindrome=true;
        while (rightChar<leftChar && isPalindrome) {
            isPalindrome = strNumber.charAt(leftChar) == strNumber.charAt(rightChar);
            if (!isPalindrome) return false;
            leftChar--;
            rightChar++;
        }
        return true;
    }
    public int invertPalindromes(int n){
        int sum = 0;
        for (int x = 0; x<=n; x++) {
            if (isPalindrome(x)) sum = sum+x;
        }
        return sum;
    }

    private void prepare(int number, int result){
        System.out.printf("\n\tValue: %d\n\tExpected: %d\n\tOutput: %d", number, result, invertPalindromes(number));
    }

    @Test
    public void testPalindrome(){
        prepare(11, 56);
        prepare(5, 15);
    }
}
/** DEBUG
 n: 5
 sum: 0
 x: 1
 strNumber: 1
 leftChar: 0
 rightChar: 0
 */