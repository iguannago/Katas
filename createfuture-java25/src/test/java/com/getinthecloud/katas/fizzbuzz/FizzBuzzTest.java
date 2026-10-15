package com.getinthecloud.katas.fizzbuzz;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Remove to begin the FizzBuzz red-green-refactor exercise")
class FizzBuzzTest {

    @Test
    void returnsAnOrdinaryNumberAsText() {
        assertEquals("1", new FizzBuzz().convert(1));
    }
}
