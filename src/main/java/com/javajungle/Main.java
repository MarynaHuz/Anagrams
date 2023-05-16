package com.javajungle;

public class Main {

    private static char[] reverseOneWord(String word) {
        char[] reversedWord = word.toCharArray();
        int firstLetter = 0;
        int lastLetter = reversedWord.length - 1;

        while(firstLetter<lastLetter){
            char temp = reversedWord[firstLetter];
            reversedWord[firstLetter] = reversedWord[lastLetter];
            reversedWord[lastLetter] = temp;

            firstLetter++;
            lastLetter--;
        }
        return reversedWord;
    }


    public static void main(String[] args) {

        String word = "abcd";
        System.out.println(reverseOneWord(word));
    }
}
