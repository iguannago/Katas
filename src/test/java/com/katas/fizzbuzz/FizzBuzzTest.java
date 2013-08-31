package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 13/08/13
 * Time: 20:32
 * This is my test class for FizzBuzz
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void oneReturnsOne() {
        assertEquals("1", fizzBuzz.evaluate(1));
    }

    @Test
    public void twoReturnsTwo() {
        assertEquals("2", fizzBuzz.evaluate(2));
    }

    @Test
    public void threeReturnsFizz() {
        assertEquals("Fizz", fizzBuzz.evaluate(3));
    }

    @Test
    public void fiveReturnBuzz() {
        assertEquals("Buzz", fizzBuzz.evaluate(5));
    }

    @Test
    public void sixReturnFizz() {
        assertEquals("Fizz", fizzBuzz.evaluate(6));
    }

    @Test
    public void tenReturnBuzz() {
        assertEquals("Buzz", fizzBuzz.evaluate(10));
    }

    @Test
    public void fifteenReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(15));
    }

    @Test
    public void thirtyReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(30));
    }

}
