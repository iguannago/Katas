package com.katas.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 05/04/2017.
 */
public class FizzBuzzTest23 {

    private FizzBuzz23 fizzBuzz23 = new FizzBuzz23();

    @Test
    public void given1Prints1() throws Exception {
        assertEquals("1", fizzBuzz23.print(1));
    }

    @Test
    public void given2Prints2() throws Exception {
        assertEquals("2", fizzBuzz23.print(2));
    }

    @Test
    public void given3PrintsFizz() throws Exception {
        assertEquals("Fizz", fizzBuzz23.print(3));
    }

    @Test
    public void given5PrintsBuzz() throws Exception {
        assertEquals("Buzz", fizzBuzz23.print(5));
    }
}
