package com.katas.fizzbuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by davicres on 25/06/2014.
 */
public class FizzBuzzTest10 {
    private FizzBuzz10 fizzBuzz10;
    //    Happy paths do not take into account input 0

    @Before
    public void setUp() throws Exception {
        fizzBuzz10 = new FizzBuzz10();
    }

    @Test
    public void OneReturnsOne() {
        Assert.assertEquals("1", fizzBuzz10.evaluate(1));
    }

    @Test
    public void TwoReturnsTwo() {
        Assert.assertEquals("2", fizzBuzz10.evaluate(2));
    }

    @Test
    public void ThreeReturnsFizz() {
        Assert.assertEquals("Fizz", fizzBuzz10.evaluate(3));
    }

    @Test
    public void FiveReturnsBuzz() {
        Assert.assertEquals("Buzz", fizzBuzz10.evaluate(5));
    }

    @Test
    public void SixReturnsFizz() {
        Assert.assertEquals("Fizz", fizzBuzz10.evaluate(6));
    }

    @Test
    public void FifteenReturnsFizzBuzz() {
        Assert.assertEquals("FizzBuzz", fizzBuzz10.evaluate(15));
    }

    // no happy paths takes into account input 0.
    // This is a business decision coming from the customer.
    @Test(expected = RuntimeException.class)
    public void ZeroThrowsException() {
        fizzBuzz10.evaluate(0);
    }

}
