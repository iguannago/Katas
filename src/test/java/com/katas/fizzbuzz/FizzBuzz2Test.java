package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 26/08/13
 * Time: 01:04
 * To change this template use File | Settings | File Templates.
 */

public class FizzBuzz2Test {

    private FizzBuzz2 fizzBuzzKata;

    @Before
    public void classInstancedTest() {
        fizzBuzzKata = new FizzBuzz2();
    }

    @Test
    public void evaluateMethodTest() {
        fizzBuzzKata = new FizzBuzz2();
        assertNotNull(fizzBuzzKata.evaluate(0));
    }

    @Test
    public void zeroReturnsZero() {
        assertEquals("0", fizzBuzzKata.evaluate(0));
    }

    @Test
    public void oneReturnsOne() {
        assertEquals("1", fizzBuzzKata.evaluate(1));
    }

    @Test
    public void threeReturnsFizz() {
        assertEquals("Fizz", fizzBuzzKata.evaluate(3));
    }

    @Test
    public void sixReturnsFizz() {
        assertEquals("Fizz", fizzBuzzKata.evaluate(6));
    }

    @Test
    public void tenReturnsBuzz() {
        assertEquals("Buzz", fizzBuzzKata.evaluate(10));
    }

    @Test
    public void fifteenReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzzKata.evaluate(15));
    }

}
