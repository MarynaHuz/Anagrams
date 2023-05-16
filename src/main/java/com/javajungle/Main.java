package com.javajungle;

import java.util.regex.Pattern;

public class Main {
    private static String reverseOneWord(String word) {
        char[] reversedWord = word.toCharArray();
        int firstLetter=0;
        int lastLetter = reversedWord.length - 1;

        while(firstLetter < lastLetter) {

            if (isNonLetterChar(reversedWord[firstLetter])){
                firstLetter++;
                continue;
            }
            if (isNonLetterChar(reversedWord[lastLetter])) {
                lastLetter--;
                continue;
            }
            char temp = reversedWord[firstLetter];
            reversedWord[firstLetter] = reversedWord[lastLetter];
            reversedWord[lastLetter] = temp;
            firstLetter++;
            lastLetter--;
        }
        return new String(reversedWord);
    }

    private static String reverseString(String text) {
        String[] separatedWords = text.split(" ");
        StringBuilder reversedText = new StringBuilder();

        for (String word : separatedWords) {
            String reversedWord = reverseOneWord(word);
            reversedText.append(reversedWord).append(" ");
        }
        return reversedText.toString().trim();
    }

    private static boolean isNonLetterChar(char character) {
        return !Pattern.matches("[a-zA-Z]", String.valueOf(character));
    }


    public static void main(String[] args) {

        String word = "abcd";
        System.out.println(reverseOneWord(word));

        String text = "a1bcd def2!ghij";
        System.out.println(reverseString(text));
    }
}
