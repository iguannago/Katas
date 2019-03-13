package com.katas.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest24 {

    private final FizzBuzz24 fizzBuzz24 = new FizzBuzz24();

    @Test
    public void given1_shouldReturn1() {
        assertEquals("1", fizzBuzz24.print(1));
    }

    @Test
    public void given2_shouldReturn2() {
        assertEquals("2", fizzBuzz24.print(2));
    }
}
