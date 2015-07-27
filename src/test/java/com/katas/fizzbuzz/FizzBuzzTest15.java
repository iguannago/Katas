package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 27/07/2015.
 */
public class FizzBuzzTest15 {

    private FizzBuzz15 fizzBuzz15;

    @Before
    public void setUp() throws Exception {
        fizzBuzz15 = new FizzBuzz15();
    }

    @Test
    public void when1ThenPrint1() {
        assertEquals("1", fizzBuzz15.print(1));
    }

    @Test
    public void when2ThenPrint2() {
        assertEquals("2", fizzBuzz15.print(2));
    }

    @Test
    public void when3ThenPrintFizz() {
        assertEquals("Fizz", fizzBuzz15.print(3));
    }

    @Test
    public void when5ThenPrintBuzz() {
        assertEquals("Buzz", fizzBuzz15.print(5));
    }

    @Test
    public void when6ThenPrintFizz() {
        assertEquals("Fizz", fizzBuzz15.print(6));
    }

    @Test
    public void when15ThenPrintFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz15.print(15));
    }

    @Test
    public void when30ThenPrintFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz15.print(30));
    }

    /**
     * Unhappy paths
     */

    @Test(expected = RuntimeException.class)
    public void whenLessThan1ThenThrowException() {
        fizzBuzz15.print(-1);
    }

    @Test(expected = RuntimeException.class)
    public void whenGreaterThan1001ThenThrowException() {
        fizzBuzz15.print(101);
    }


}
