package com.sleepsoft.challenges.leetcode;


import org.junit.Test;


public class CharsInWord {
        public int countCharacters(String[] words, String chars) {
            int wordCount=0;
            for(String word:words){
                String wordClone = word;
                boolean containsAllChars=true;
                while (wordClone.length()>0 && containsAllChars){
                    String character = wordClone.substring(0,1);
                    if (wordClone.length()>1) wordClone = wordClone.substring(1);
                    else wordClone="";
                    if (chars.indexOf(character)<0) containsAllChars=false;
                }
                if (containsAllChars) wordCount+=word.length();
            }
            return wordCount;
        }

    @Test
        public void testcountChars(){
           CharsInWord ciw = new CharsInWord();
           String[] words= new String[]{"cat","bt","hat","tree"};
           String search ="atach";
           System.out.printf("Testing %s, with %s: Expected 6  Output:%d\n", String.join(", ", words), search,
                   ciw.countCharacters(words, search));
    }
}
