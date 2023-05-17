package com.javajungle;

import static com.javajungle.AnagramMaker.*;

public class AnagramApp {

    public static void main(String[] args) {

        String word = "abcd";
        System.out.println(reverse(word));

        String sentence = "a1bcd def2!ghij";
        System.out.println(make(sentence));
    }
}
