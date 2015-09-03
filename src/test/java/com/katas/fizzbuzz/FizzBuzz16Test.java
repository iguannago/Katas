package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 03/09/2015.
 */
public class FizzBuzz16Test {

    private FizzBuzz16 fizzBuzz16;

    @Before
    public void setUp() throws Exception {
        fizzBuzz16 = new FizzBuzz16();
    }

    @Test
    public void when1Prints1() {
        assertEquals("1", fizzBuzz16.print(1));
    }
    @Test
    public void when2Prints2() {
        assertEquals("2", fizzBuzz16.print(2));
    }
    @Test
    public void when3PrintsFizz() {
        assertEquals("Fizz", fizzBuzz16.print(3));
    }
    @Test
    public void when5PrintsBuzz() {
        assertEquals("Buzz", fizzBuzz16.print(5));
    }
    @Test
    public void when6PrintsFizz() {
        assertEquals("Fizz", fizzBuzz16.print(6));
    }
    @Test
    public void when8Prints8() {
        assertEquals("8", fizzBuzz16.print(8));
    }
    @Test
    public void when15PrintsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz16.print(15));
    }
    @Test (expected = RuntimeException.class)
    public void whenNumberLowerThan1ThenException() {
        fizzBuzz16.print(0);
    }
    @Test (expected = RuntimeException.class)
    public void whenNumberGreaterThan100ThenException() {
        fizzBuzz16.print(101);
    }





}
