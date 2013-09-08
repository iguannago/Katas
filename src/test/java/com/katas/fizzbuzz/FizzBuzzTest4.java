package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 08/09/13
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
@RunWith(JUnit4.class)
public class FizzBuzzTest4 {

    private FizzBuzz4 fizzBuzz4;

    @Before
    public void setUp() {
        fizzBuzz4 = new FizzBuzz4();
    }

    @Test
    public void classExists() {
        assertNotNull(fizzBuzz4);
    }

    @Test
    public void evaluateMethodTest() {
        assertNotNull(fizzBuzz4.evaluate(1));
    }

    @Test
    public void zeroReturnsZero() {
        assertEquals("0", fizzBuzz4.evaluate(0));
    }

    @Test
    public void oneReturnsOne() {
        assertEquals("1", fizzBuzz4.evaluate(1));
    }

    @Test
    public void twoReturnsTwo() {
        assertEquals("2", fizzBuzz4.evaluate(2));
    }

    @Test
    public void threeReturnsFizz() {
        assertEquals("Fizz", fizzBuzz4.evaluate(3));
    }

    @Test
    public void fiveReturnsBuzz() {
        assertEquals("Buzz", fizzBuzz4.evaluate(5));
    }

    @Test
    public void sixReturnsSix() {
        assertEquals("Fizz", fizzBuzz4.evaluate(6));
    }

    @Test
    public void tenReturnsTen() {
        assertEquals("Buzz", fizzBuzz4.evaluate(10));
    }

    @Test
    public void fifteenReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz4.evaluate(15));
    }

    @Test
    public void thirtyReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz4.evaluate(30));
    }




}
