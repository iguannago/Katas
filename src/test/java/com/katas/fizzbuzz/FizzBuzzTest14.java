package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 29/05/2015.
 * "Write a program that prints the numbers from 1 to 100.
 * But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
 * For numbers which are multiples of both three and five print “FizzBuzz”."
 * Return an exception when the input is less than 1 and higher than 100
 */
public class FizzBuzzTest14 {

    private FizzBuzz14 fizzBuzz14;

    @Before
    public void setUp() throws Exception {
        fizzBuzz14 = new FizzBuzz14();
    }

    @Test
    public void when1print1() {
        assertEquals("1", fizzBuzz14.print(1));
    }

    @Test
    public void when2print2() {
        assertEquals("2", fizzBuzz14.print(2));
    }

    @Test
    public void when3printFizz() {
        assertEquals("Fizz", fizzBuzz14.print(3));
    }

    @Test
    public void when5printBuzz() {
        assertEquals("Buzz", fizzBuzz14.print(5));
    }

    @Test
    public void when15PrintFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz14.print(15));
    }

//    Testing boundaries.

    @Test(expected = RuntimeException.class)
    public void when0ThrowException() {
        fizzBuzz14.print(0);
    }

    @Test(expected = RuntimeException.class)
    public void when101ThrowException() {
        fizzBuzz14.print(101);
    }
}
