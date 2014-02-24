package com.katas.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dcrespo on 24/02/14.
 */
public class FizzBuzzTest8 {

    private FizzBuzz8 fizzBuzz8 = new FizzBuzz8();

    @Test
    public void if1Returns1() {
        Assert.assertEquals("1", fizzBuzz8.play(1));
    }

    @Test
    public void if2Returns2() {
        Assert.assertEquals("2", fizzBuzz8.play(2));
    }

    @Test
    public void if3ReturnsFizz() {
        Assert.assertEquals("Fizz", fizzBuzz8.play(3));
    }

    @Test
    public void if5ReturnsBuzz() {
        Assert.assertEquals("Buzz", fizzBuzz8.play(5));
    }

    @Test
    public void if6ReturnsFizz() {
        Assert.assertEquals("Fizz", fizzBuzz8.play(6));
    }

    @Test
    public void if9ReturnsFizz() {
        Assert.assertEquals("Fizz", fizzBuzz8.play(9));
    }

    @Test
    public void if10ReturnsBuzz() {
        Assert.assertEquals("Buzz", fizzBuzz8.play(10));
    }

    @Test
    public void if12ReturnsFizz() {
        Assert.assertEquals("Fizz", fizzBuzz8.play(12));
    }

    @Test
    public void if15ReturnsFizzBuzz() {
        Assert.assertEquals("FizzBuzz", fizzBuzz8.play(15));
    }

    @Test
    public void if30ReturnsFizzBuzz() {
        Assert.assertEquals("FizzBuzz", fizzBuzz8.play(30));
    }

}
