package com.katas.fizzbuzz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by dcrespo on 19/01/14.
 */
@RunWith(JUnit4.class)
public class FizzBuzzTest7 {

    private FizzBuzz7 fizzBuzz7;

    private static Log logger = LogFactory.getLog(FizzBuzzTest7.class);

    @Before
    public void setUp() {
        fizzBuzz7 = new FizzBuzz7();
    }

    @Test
    public void oneReturns1() {
        Assert.assertEquals("It Should returns 1", "1", fizzBuzz7.play(1));
    }

    @Test
    public void threeReturnsFizz() {
        Assert.assertEquals("It should return Fizz", "Fizz", fizzBuzz7.play(3));

    }

    @Test
    public void fiveReturnsBuzz() {
        Assert.assertEquals("It should return Buzz", "Buzz", fizzBuzz7.play(5));
    }

    @Test
    public void nineReturnsFizz() {
        Assert.assertEquals("It should return Fizz", "Fizz", fizzBuzz7.play(9));
    }

    @Test
    public void tenReturnsBuzz() {
        Assert.assertEquals("It should return Buzz", "Buzz", fizzBuzz7.play(10));
    }

    @Test
    public void elevenReturns11() {
        Assert.assertEquals("It should return 11", "11", fizzBuzz7.play(11));
    }

    @Test
    public void twelveReturnsFizz() {
        Assert.assertEquals("It should return Fizz", "Fizz", fizzBuzz7.play(12));
    }

    @Test
    public void fifteenReturnsFizzBuzz() {
        Assert.assertEquals("It should return FizzBuzz", "FizzBuzz", fizzBuzz7.play(15));
    }

    @Test
    public void thirtyReturnsFizzBuzz() {
        Assert.assertEquals("It should return FizzBuzz", "FizzBuzz", fizzBuzz7.play(30));
    }


}
