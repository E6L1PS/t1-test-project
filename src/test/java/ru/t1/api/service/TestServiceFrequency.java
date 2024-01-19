package ru.t1.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestServiceFrequency {

    private final FrequencyService frequencyService = new FrequencyService();

    @Test
    void testCalculateCharacterFrequencyWithEmptyLine() {
        String line = "";
        assertTrue(frequencyService.calculateCharacterFrequency(line).isEmpty());
    }

    @Test
    void testCalculateCharacterFrequencyWithSingleCharacter() {
        String line = "a";
        assertEquals(1, frequencyService.calculateCharacterFrequency(line).size());
        assertEquals('a', frequencyService.calculateCharacterFrequency(line).get(0).getCharacter());
        assertEquals(1, frequencyService.calculateCharacterFrequency(line).get(0).getFrequency());
    }

    @Test
    void testCalculateCharacterFrequencyWithMultipleCharacters() {
        String line = "aabcc";
        assertEquals(3, frequencyService.calculateCharacterFrequency(line).size());

        assertEquals('a', frequencyService.calculateCharacterFrequency(line).get(0).getCharacter());
        assertEquals(2, frequencyService.calculateCharacterFrequency(line).get(0).getFrequency());

        assertEquals('c', frequencyService.calculateCharacterFrequency(line).get(1).getCharacter());
        assertEquals(2, frequencyService.calculateCharacterFrequency(line).get(1).getFrequency());

        assertEquals('b', frequencyService.calculateCharacterFrequency(line).get(2).getCharacter());
        assertEquals(1, frequencyService.calculateCharacterFrequency(line).get(2).getFrequency());
    }

    @Test
    void testCalculateCharacterFrequencyWithSpaces() {
        String line = "a b c";
        assertEquals(4, frequencyService.calculateCharacterFrequency(line).size());

        assertEquals(' ', frequencyService.calculateCharacterFrequency(line).get(0).getCharacter());
        assertEquals(2, frequencyService.calculateCharacterFrequency(line).get(0).getFrequency());

        assertEquals('a', frequencyService.calculateCharacterFrequency(line).get(1).getCharacter());
        assertEquals(1, frequencyService.calculateCharacterFrequency(line).get(1).getFrequency());

        assertEquals('b', frequencyService.calculateCharacterFrequency(line).get(2).getCharacter());
        assertEquals(1, frequencyService.calculateCharacterFrequency(line).get(2).getFrequency());

        assertEquals('c', frequencyService.calculateCharacterFrequency(line).get(3).getCharacter());
        assertEquals(1, frequencyService.calculateCharacterFrequency(line).get(3).getFrequency());
    }
}