package com.getinthecloud.katas.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FizzBuzzTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7})
    void returnsAnOrdinaryNumberAsText(int number) {
        assertEquals(String.valueOf(number), new FizzBuzz().convert(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void returnsFizz(int number) {
        assertEquals("Fizz", new FizzBuzz().convert(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void returnsBuzz(int number) {
        assertEquals("Buzz", new FizzBuzz().convert(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30})
    void returnsFizzBuzz(int number) {
        assertEquals("FizzBuzz", new FizzBuzz().convert(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void rejectsZeroAndNegativeNumbers(int number) {
        assertThrows(IllegalArgumentException.class, () -> new FizzBuzz().convert(number));
    }
}
