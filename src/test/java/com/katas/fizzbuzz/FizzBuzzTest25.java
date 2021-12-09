package com.katas.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;


public class FizzBuzzTest25 {

    private final FizzBuzz25 fizzBuzz25 = new FizzBuzz25();

    @Test
    public void when_one_then_one() {
        String actual = fizzBuzz25.fizzbuzz(1);

        Assert.assertEquals("1", actual);
    }

    @Test
    public void when_two_then_two() {
        String actual = fizzBuzz25.fizzbuzz(2);

        Assert.assertEquals("2", actual);
    }

    @Test
    public void when_three_then_Fizz() {
        String actual = fizzBuzz25.fizzbuzz(2);

        Assert.assertEquals("2", actual);
    }
}
