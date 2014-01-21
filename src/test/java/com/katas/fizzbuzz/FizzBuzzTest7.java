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
    public void if1Return1() {
        Assert.assertEquals("It Should returns 1", "1", fizzBuzz7.play(1));
    }

    public void if3ReturnFizz() {
        Assert.assertEquals("It should return Fizz", "Fizz", "");fizzBuzz7.play(3);

    }





}
