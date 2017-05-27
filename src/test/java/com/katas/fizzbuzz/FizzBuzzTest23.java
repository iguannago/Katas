package com.katas.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 05/04/2017.
 */
public class FizzBuzzTest23 {
    @Test
    public void given1Prints1() throws Exception {
        FizzBuzz23 fizzBuzz23 = new FizzBuzz23();
        String result = fizzBuzz23.print(1);
        assertEquals("1", result);
    }
}
