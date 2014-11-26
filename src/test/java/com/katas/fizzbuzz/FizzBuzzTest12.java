package com.katas.fizzbuzz;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 26/11/2014.
 */
public class FizzBuzzTest12 {

    private FizzBuzz12 fizzBuzz12;

    @Before
    public void setUp() throws Exception {
        fizzBuzz12 = new FizzBuzz12();
    }

    @Test
    public void when1Return1() {
        assertEquals("1", fizzBuzz12.print(1));
    }

    @Test
    public void when2Return2() {
        assertEquals("2", fizzBuzz12.print(2));
    }
    @Test
    public void when3ReturnFizz() {
        assertEquals("Fizz", fizzBuzz12.print(3));
    }
    @Test
    public void when5ReturnBuzz() {
        assertEquals("Buzz", fizzBuzz12.print(5));
    }
    @Test
    public void when15ReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz12.print(15));
    }

}
