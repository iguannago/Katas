package com.getinthecloud.programming.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/03/2016.
 */
public class FizzBuzzStep1Test {
    @Test
    public void when1Prints1() {
       FizzBuzzStep1 fizzBuzzStep1 = new FizzBuzzStep1();
        int number = 1;
        String result = fizzBuzzStep1.printFizzBuzz(number);
        assertEquals("1", result);
    }
}
