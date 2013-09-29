package com.katas.fizzbuzz;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 29/09/13
 * Time: 00:34
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzzTest6 {

    private FizzBuzz6 fizzBuzz6;

    @Before
    public void setUp() {
        fizzBuzz6 = new FizzBuzz6();
    }

    @Test
    public void instanceOfClassTest() {
        Assert.assertThat(fizzBuzz6, CoreMatchers.notNullValue());
    }

    @Test
    public void methodOfClassTest() {
        Assert.assertThat(fizzBuzz6.evaluate(0), CoreMatchers.notNullValue());
    }

    @Test
    public void zeroReturnZero() {
        Assert.assertEquals(fizzBuzz6.evaluate(0), "FizzBuzz");
    }

    @Test
    public void oneReturnOne() {
        Assert.assertEquals(fizzBuzz6.evaluate(1), "1");
    }

    @Test
    public void threeReturnFizz() {
        Assert.assertEquals(fizzBuzz6.evaluate(3), "Fizz");
    }

    @Test
    public void fiveReturnBuzz() {
        Assert.assertEquals(fizzBuzz6.evaluate(5), "Buzz");
    }

    @Test
    public void sixReturnFizz() {
        Assert.assertEquals(fizzBuzz6.evaluate(6), "Fizz");
    }

    @Test
    public void nineReturnFizz() {
        Assert.assertEquals(fizzBuzz6.evaluate(9), "Fizz");
    }

    @Test
    public void tenReturnBuzz() {
        Assert.assertEquals(fizzBuzz6.evaluate(10), "Buzz");
    }

    @Test
    public void fifteenReturnFizzBuzz() {
        Assert.assertEquals(fizzBuzz6.evaluate(15), "FizzBuzz");
    }

    @Test
    public void thirtyReturnFizzBuzz() {
        Assert.assertEquals(fizzBuzz6.evaluate(30), "FizzBuzz");
    }

}
