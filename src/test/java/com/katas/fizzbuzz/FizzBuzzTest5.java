package com.katas.fizzbuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 14/09/13
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzzTest5 {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = "FizzBuzz";
    private FizzBuzz5 fizzBuzz5;

    @Before
    public void setUp() {
        fizzBuzz5 = new FizzBuzz5();
    }

    @Test
    public void zeroReturnZero() {
        Assert.assertEquals("0", fizzBuzz5.evaluate(0));
    }

    @Test
    public void oneReturnOne() {
        Assert.assertEquals("1", fizzBuzz5.evaluate(1));
    }

    @Test
    public void threeReturnFizz() {
        Assert.assertEquals(FIZZ, fizzBuzz5.evaluate(3));
    }

    @Test
    public void fiveReturnBuzz() {
        Assert.assertEquals(BUZZ, fizzBuzz5.evaluate(5));
    }

    @Test
    public void sixReturnFizz() {
        Assert.assertEquals(FIZZ, fizzBuzz5.evaluate(6));
    }

    @Test
    public void nineReturnFizz() {
        Assert.assertEquals(FIZZ, fizzBuzz5.evaluate(9));
    }

    @Test
    public void tenReturnBuzz() {
        Assert.assertEquals(BUZZ, fizzBuzz5.evaluate(10));
    }

    @Test
    public void fifteenReturnFizzBuzz() {
        Assert.assertEquals(FIZZ_BUZZ, fizzBuzz5.evaluate(15));
    }

    @Test
    public void thirtyReturnFizzBuzz() {
        Assert.assertEquals(FIZZ_BUZZ, fizzBuzz5.evaluate(30));
    }

}
