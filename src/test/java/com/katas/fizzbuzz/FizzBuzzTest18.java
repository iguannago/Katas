package com.katas.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 30/06/2016.
 */
public class FizzBuzzTest18 {
    @Test
    public void when1Prints1Test() {
        FizzBuzz18 fizzBuzz18 = new FizzBuzz18();
        String result = fizzBuzz18.print(1);
        assertEquals("1", result);
    }

    @Test
    public void when2Prints2Test() {
        FizzBuzz18 fizzBuzz18 = new FizzBuzz18();
        String result = fizzBuzz18.print(2);
        assertEquals("2", result);
    }

}
