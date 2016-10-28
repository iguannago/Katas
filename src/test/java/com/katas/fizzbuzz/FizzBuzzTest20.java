package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 28/10/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest20 {

    private final FizzBuzz20 fizzBuzz20 = new FizzBuzz20();

    @Test
    @Parameters({"1, 1", "2, 2", "Fizz, 3", "4, 4", "Buzz, 5", "Fizz, 6", "7, 7", "Fizz, 9", "Buzz, 10",
    "FizzBuzz, 15", "FizzBuzz, 30"})
    public void printMethodTest(String expected, int input) {
        assertEquals(expected, fizzBuzz20.print(input));
    }

    @Test(expected = RuntimeException.class)
    public void ifInputIsGreaterThan100ThrowExceptionTest() {
        fizzBuzz20.print(101);
    }

    @Test(expected = RuntimeException.class)
    public void ifInputIsLowerThan1ThrowExceptionTest() {
        fizzBuzz20.print(0);
    }

}
