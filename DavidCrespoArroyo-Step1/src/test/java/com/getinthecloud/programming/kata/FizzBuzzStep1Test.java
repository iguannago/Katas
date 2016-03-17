package com.getinthecloud.programming.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/03/2016.
 */
public class FizzBuzzStep1Test {

    private final FizzBuzzStep1 fizzBuzzStep1 = new FizzBuzzStep1();

    @Test
    public void when1Prints1() {
        assertEquals("1", fizzBuzzStep1.printFizzBuzz(1));
    }

    @Test
    public void when2Prints2() {
        assertEquals("2", fizzBuzzStep1.printFizzBuzz(2));
    }

}
