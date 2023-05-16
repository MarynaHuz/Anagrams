package com.javajungle;

import java.util.regex.Pattern;

public class Main {
    private static String reverseOneWord(String word) {
        char[] reversedWord = word.toCharArray();
        int firstLetter;
        int lastLetter = reversedWord.length - 1;

        for (firstLetter = 0; firstLetter < lastLetter; firstLetter++) {

            if (isLetterChar(reversedWord[firstLetter]) && isLetterChar(reversedWord[lastLetter])) {
                reverse(reversedWord, firstLetter, lastLetter);

            } else if (!isLetterChar(reversedWord[firstLetter]) && isLetterChar(reversedWord[lastLetter])) {
                firstLetter++;
                reverse(reversedWord, firstLetter, lastLetter);

            } else if (isLetterChar(reversedWord[firstLetter]) && !isLetterChar(reversedWord[lastLetter])) {
                lastLetter--;
                reverse(reversedWord, firstLetter, lastLetter);

            } else {
                firstLetter++;
                lastLetter--;
                reverse(reversedWord, firstLetter, lastLetter);
            }
            lastLetter--;
        }
        return new String(reversedWord);
    }

    private static void reverse(char[] reversedWord, int firstLetter, int lastLetter) {
        char temp = reversedWord[firstLetter];
        reversedWord[firstLetter] = reversedWord[lastLetter];
        reversedWord[lastLetter] = temp;
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

    private static boolean isLetterChar(char character) {
        return Pattern.matches("[a-zA-Z]", String.valueOf(character));
    }


    public static void main(String[] args) {

        String word = "abcd";
        System.out.println(reverseOneWord(word));

        String text = "a1bcd 2tfg!h";
        System.out.println(reverseString(text));
    }
}
