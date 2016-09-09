package com.katas.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 09/09/2016.
 */
public class FizzBuzzTest19 {

    @Test
    public void print1When1Test() {
        FizzBuzz19 fizzBuzz19 = new FizzBuzz19();
        assertEquals("1", fizzBuzz19.print(1));
    }

    @Test
    public void print2When2Test() {
        FizzBuzz19 fizzBuzz19 = new FizzBuzz19();
        assertEquals("2", fizzBuzz19.print(2));
    }


}
