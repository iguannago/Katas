package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 27/04/2015.
 * "Write a program that prints the numbers from 1 to 100.
 * But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
 * For numbers which are multiples of both three and five print “FizzBuzz”."
 */
public class FizzBuzzTest13 {

    private FizzBuzz13 fizzbuzz13;

    @Before
    public void setUp() throws Exception {
        fizzbuzz13 = new FizzBuzz13();
    }

    @Test
    public void when1ThenReturn1() {
        assertEquals("1", fizzbuzz13.print(1));
    }
    @Test
    public void when2ThenReturn2() {
        assertEquals("2", fizzbuzz13.print(2));
    }
    @Test
    public void when3ThenReturnFizz() {
        assertEquals("Fizz", fizzbuzz13.print(3));
    }
    @Test
    public void when4ThenReturn4() {
        assertEquals("4", fizzbuzz13.print(4));
    }
    @Test
    public void when5ThenReturnBuzz() {
        assertEquals("Buzz", fizzbuzz13.print(5));
    }
    @Test
    public void when15ThenReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzbuzz13.print(15));
    }
    @Test
    public void list1To100Test() {
        fizzbuzz13.listFrom1To100();
    }

}
