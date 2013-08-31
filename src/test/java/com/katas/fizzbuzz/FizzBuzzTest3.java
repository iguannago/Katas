package com.katas.fizzbuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 31/08/13
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzzTest3 {

    private FizzBuzz3 fizzBuzz3;

    @Before
    public void setUp() {
        fizzBuzz3 = new FizzBuzz3();
    }

    @Test
    public void classInstanceTest() {
        Assert.assertNotNull(fizzBuzz3);
    }

    @Test
    public void methodTest() {
        Assert.assertNotNull(fizzBuzz3.evaluate(0));
    }

    @Test
    public void zeroReturnZero() {
        Assert.assertEquals("0", fizzBuzz3.evaluate(0));
    }

    @Test
    public void oneReturnOne() {
        Assert.assertEquals("1", fizzBuzz3.evaluate(1));
    }

    @Test
    public void threeReturnFizz() {
        Assert.assertEquals("Fizz", fizzBuzz3.evaluate(3));
    }

    @Test
    public void fiveReturnBuzz() {
        Assert.assertEquals("Buzz", fizzBuzz3.evaluate(5));
    }

    @Test
    public void sixReturnFizz() {
        Assert.assertEquals("Fizz", fizzBuzz3.evaluate(6));
    }

    @Test
    public void nineReturnFizz() {
        Assert.assertEquals("Fizz", fizzBuzz3.evaluate(9));
    }

    @Test
    public void tenReturnBuzz() {
        Assert.assertEquals("Buzz", fizzBuzz3.evaluate(10));
    }

    @Test
    public void fifteenReturnFizzBuzz() {
        Assert.assertEquals("FizzBuzz", fizzBuzz3.evaluate(15));
    }

    @Test
    public void thirtyReturnFizzBuzz() {
        Assert.assertEquals("FizzBuzz", fizzBuzz3.evaluate(30));
    }
}
