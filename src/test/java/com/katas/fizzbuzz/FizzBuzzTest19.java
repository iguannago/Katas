package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 09/09/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest19 {

    @Test
    @Parameters({"1, 1", "2, 2", "Fizz, 3", "Buzz, 5", "Fizz, 6", "7, 7"})
    public void print1When1Test(String expected, int number) {
        FizzBuzz19 fizzBuzz19 = new FizzBuzz19();
        assertEquals(expected, fizzBuzz19.print(number));
    }

}
