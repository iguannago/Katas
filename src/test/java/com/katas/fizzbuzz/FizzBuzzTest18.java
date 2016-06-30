package com.katas.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 30/06/2016.
 */
public class FizzBuzzTest18 {

    private final FizzBuzz18 fizzBuzz18 = new FizzBuzz18();

    @Test
    public void when1Prints1Test() {
        assertEquals("1", fizzBuzz18.print(1));
    }

    @Test
    public void when2Prints2Test() {
        assertEquals("2", fizzBuzz18.print(2));
    }

}
