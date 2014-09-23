package com.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 04/09/2014.
 * <p/>
 * Exercise:
 * "Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the
 * number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five
 * print “FizzBuzz”."
 * <p/>
 * Source: http://c2.com/cgi/wiki?FizzBuzzTest
 */
public class FizzBuzzTest11 {

    private FizzBuzz11 fizzBuzz11;

    @Before
    public void setUp() throws Exception {
        fizzBuzz11 = new FizzBuzz11();
    }

    @Test
    public void print1WhenInputIs1Test() {
        assertEquals("1", fizzBuzz11.print(1));
    }

    @Test
    public void print2WhenInputIs2Test() {
        assertEquals("2", fizzBuzz11.print(2));
    }

    @Test
    public void printFizzWhenInputIs3Test() {
        assertEquals("Fizz", fizzBuzz11.print(3));
    }

    @Test
    public void print4WhenInputIs4Test() {
        assertEquals("4", fizzBuzz11.print(4));
    }

    @Test
    public void printBuzzWhenInputIs5Test() {
        assertEquals("Buzz", fizzBuzz11.print(5));
    }

    @Test
    public void printFizzBuzzWhenInputIs15Test() {
        assertEquals("FizzBuzz", fizzBuzz11.print(15));
    }


}
