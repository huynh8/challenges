package com.example.missingletters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingLettersFinderTest {

    MissingLettersFinder missingLettersFinder;

    @BeforeEach
    void setUp() {
        missingLettersFinder = new MissingLettersFinder();
    }

    @DisplayName("getMissingLetters missing letters for input with pangram returns no letters")
    @Test
    void findLetters_pangram() {
        String input = "A quick brown fox jumps over the lazy dog";

        String output = missingLettersFinder.getMissingLetters(input);

        assertEquals("", output);
    }

    @DisplayName("getMissingLetters missing letters for empty input returns all letters")
    @Test
    void findLetters_emptyInput() {
        String input = "";

        String output = missingLettersFinder.getMissingLetters(input);

        assertEquals("abcdefghijklmnopqrstuvwxyz", output);
    }

    @DisplayName("getMissingLetters missing letters for input returns missing letters")
    @Test
    void findLetters() {
        String input = "A slow yellow fox crawls under the proactive dog";

        String output = missingLettersFinder.getMissingLetters(input);

        assertEquals("bjkmqz", output);
    }

    @DisplayName("getMissingLetters missing letters for input with non-alpha chars returns missing letters")
    @Test
    void findLetters_withNonAlpha() {
        String input = "Lions, and tigers, and bears, oh my!";

        String output = missingLettersFinder.getMissingLetters(input);

        assertEquals("cfjkpquvwxz", output);

    }
}