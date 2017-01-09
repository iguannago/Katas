package com.katas.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 09/01/2017.
 */
public class FizzBuzzTest22 {
    @Test
    public void when1Print1() throws Exception {
        FizzBuzz22 fizzBuzz22 = new FizzBuzz22();
        assertEquals("1", fizzBuzz22.print(1));
    }

    @Test
    public void when3PrintFizz() throws Exception {
        FizzBuzz22 fizzBuzz22 = new FizzBuzz22();
        assertEquals("Fizz", fizzBuzz22.print(3));
    }
}
