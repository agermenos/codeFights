package com.sleepsoft.challenges.learn.from;
/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "a good example"
Output: "example good a"

Example 3:

Input: s = "Bob Loves Alice"
Output: "Alice Loves Bob"
*/


/* Name of the class has to be "Main" only if the class is public. */
class WordReverser
{
    public String reverseSentence(String sentence){
        String[] words = sentence.split(" ");
        String[] reverseString = new String[words.length];
        int counter = 0;
        for (String word:words){
            reverseString[words.length-1-counter] = word;
            counter++;
        }
        StringBuilder strResponse = new StringBuilder();
        for (String element : reverseString) {
            strResponse.append(element+" ");
        }
        return strResponse.toString();
    }

    public static void main (String[] args)
    {
        WordReverser wr = new WordReverser();
        String response = wr.reverseSentence("the sky is blue");

        System.out.println("Testing [the sky is blue]\n\tExpected: [blue, is, sky, the]\n\tOutput:" + response);
        System.out.println("Testing [a good example]\n\tExpected: [example good a]\n\tOutput:" + wr.reverseSentence("a good example"));
        System.out.println("Testing []\n\tExpected: []\n\tOutput:" + wr.reverseSentence(""));
    }
}
/** DEBUG
 sentence: the sky is blue (4)
 words: ["the", "sky", "is", "blue"]
 reverseString: [blue,is,sky,the]
 counter: 3
 word: the
 * */