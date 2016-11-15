package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 15/11/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest21 {

    private final FizzBuzz21 fizzBuzz21 = new FizzBuzz21();

    @Test
    @Parameters({"1, 1", "2, 2", "3, Fizz", "4, 4", "5, Buzz", "6, Fizz", "7, 7", "9, Fizz", "10, Buzz",
            "11, 11", "12, Fizz", "15, FizzBuzz"})
    public void printMethodTest(int input, String expected) {
        String actual = fizzBuzz21.print(input);
        assertEquals(expected, actual);
    }

    //corner cases
    @Test(expected = RuntimeException.class)
    @Parameters({"0", "-1", "101", "102"})
    public void whenNumberLowerThan1OrGreaterThan100ThrowExceptionTest(int input) {
        fizzBuzz21.print(input);
    }


}
