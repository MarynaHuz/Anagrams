package com.javajungle;

import java.util.StringJoiner;
import java.util.regex.Pattern;

public class AnagramMaker {
    public static String reverse(String word) {

        if (word == null) {
            throw new IllegalArgumentException("Input word cannot be null");
        }

        char[] reversedWord = word.toCharArray();
        int left = 0;
        int right = reversedWord.length - 1;

        while (left < right) {

            if (isNonLetterChar(reversedWord[left])) {
                left++;
                continue;
            }
            if (isNonLetterChar(reversedWord[right])) {
                right--;
                continue;
            }
            char temp = reversedWord[left];
            reversedWord[left] = reversedWord[right];
            reversedWord[right] = temp;
            left++;
            right--;
        }
        return new String(reversedWord);
    }

    public static String make(String sentence) {

        if (sentence == null) {
            throw new IllegalArgumentException("Input sentence cannot be null");
        }

        String[] separatedWords = sentence.split(" ", -1);
        StringJoiner reversedSentence = new StringJoiner(" ");

        for (String word : separatedWords) {
            String reversedWord = reverse(word);
            reversedSentence.add(reversedWord);
        }
        return reversedSentence.toString();
    }

    public static boolean isNonLetterChar(char character) {
        return !Pattern.matches("[a-zA-Z]", String.valueOf(character));
    }
}
