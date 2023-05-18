package com.javajungle;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramMakerTest {

    @Test
    void reverse_shouldReturnIllegalArgumentException_WhenInputIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> AnagramMaker.reverse(null));
        assertEquals("Input word cannot be null", exception.getMessage());
    }

    @Test
    void make_shouldReturnIllegalArgumentException_WhenInputIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> AnagramMaker.make(null));
        assertEquals("Input sentence cannot be null", exception.getMessage());
    }

    @Test
    void make_shouldReturnSameAmountOfSpaces_whenInputSentenceContainsOnlySpaces() {
        assertEquals("    ", AnagramMaker.make("    "));
    }

    @Test
    void make_shouldReturnSingleSpace_whenInputSentenceContainsOnlySingleSpace() {
        assertEquals(" ", AnagramMaker.make(" "));
    }

    @Test
    void make_shouldReturnSymbolsInTheSameOrder_whenInputSentenceContainsOnlySymbols() {
        assertEquals("11! 22-63#", AnagramMaker.reverse("11! 22-63#"));
    }

    @Test
    void reverse_shouldReturnReversedWordAndKeepSymbolOnTheSamePlaces_whenInputWordContainsSymbolsAndLetters() {
        assertEquals("emkce11hc", AnagramMaker.reverse("check11me"));
    }

    @Test
    void make_shouldReturnEmptyString_whenInputIsEmptyString() {
        assertEquals("", AnagramMaker.make(""));
    }

    @Test
    void make_shouldReturnReversedSentenceAndKeepSymbolOnTheSamePlaces_whenInputSentenceContainsSymbolsAndLetters() {
        assertEquals("emkce11hc nia!ga dna ni!aga", AnagramMaker.make("check11me aga!in and ag!ain"));
    }
}