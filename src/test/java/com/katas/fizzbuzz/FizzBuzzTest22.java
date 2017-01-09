package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 09/01/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest22 {

    private final FizzBuzz22 fizzBuzz22 = new FizzBuzz22();

    @Test
    @Parameters({"1, 1", "3, Fizz", "4, 4", "5, Buzz", "6, Fizz", "7, 7", "9, Fizz", "10, Buzz", "12, Fizz",
            "15, FizzBuzz", "18, Fizz", "20, Buzz", "30, FizzBuzz"})
    public void when1Print1(int input, String expected) throws Exception {
        assertEquals(expected, fizzBuzz22.print(input));
    }

    //corner cases

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"0", "-1", "101"})
    public void ifLowerThan1OrGreaterThan100ThrowException(int input) throws Exception {
        fizzBuzz22.print(input);
    }
}
