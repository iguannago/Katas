package com.katas.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest24 {
    @Test
    public void given1_shouldReturn1() {
        FizzBuzz24 fizzBuzz24 = new FizzBuzz24();
        String result = fizzBuzz24.print(1);
        assertEquals("1", result);
    }
}
