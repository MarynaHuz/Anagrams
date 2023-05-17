package com.javajungle;

import java.util.StringJoiner;
import java.util.regex.Pattern;

public class AnagramMaker {
    public static String reverse(String word) {
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
        String[] separatedWords = sentence.split(" ");
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
