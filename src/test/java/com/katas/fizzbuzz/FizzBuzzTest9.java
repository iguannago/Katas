package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 21/04/2014.
 */
public class FizzBuzzTest9 {

    private FizzBuzz9 fizzbuzz9;

    @Before
    public void setUp() throws Exception {
        fizzbuzz9 = new FizzBuzz9();
    }

    //First we test the happy paths
    @Test
    public void given1Return1() {
        assertEquals("Expected is 1", "1", fizzbuzz9.evaluate(1));
    }

    @Test
    public void given2Return2() {
        assertEquals("Expected is 2", "2", fizzbuzz9.evaluate(2));
    }

    @Test
    public void given3ReturnFizz() {
        assertEquals("Expected is Fizz", "Fizz", fizzbuzz9.evaluate(3));
    }

    @Test
    public void given4Return4() {
        assertEquals("Expected is 4", "4", fizzbuzz9.evaluate(4));
    }

    @Test
    public void given5ReturnBuzz() {
        assertEquals("Expected is Buzz", "Buzz", fizzbuzz9.evaluate(5));
    }

    @Test
    public void given6ReturnFizz() {
        assertEquals("Expected is Fizz", "Fizz", fizzbuzz9.evaluate(6));
    }

    @Test
    public void given7Return7() {
        assertEquals("Expected is 7", "7", fizzbuzz9.evaluate(7));
    }

    @Test
    public void given9ReturnFizz() {
        assertEquals("Expected is Fizz", "Fizz", fizzbuzz9.evaluate(9));
    }

    @Test
    public void given10ReturnBuzz() {
        assertEquals("Expected is Buzz", "Buzz", fizzbuzz9.evaluate(10));
    }

    @Test
    public void given15ReturnFizzBuzz() {
        assertEquals("Expected is FizzBuzz", "FizzBuzz", fizzbuzz9.evaluate(15));
    }

    @Test
    public void given30ReturnFizzBuzz() {
        assertEquals("Expected is FizzBuzz", "FizzBuzz", fizzbuzz9.evaluate(30));
    }

    //Now wee can test corner cases.
    @Test
    public void given0ReturnFizzBuzz() {
        assertEquals("Expected is FizzBuzz", "FizzBuzz", fizzbuzz9.evaluate(0));
    }

}
