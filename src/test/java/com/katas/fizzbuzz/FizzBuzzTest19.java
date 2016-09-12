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

    private final FizzBuzz19 fizzBuzz19 = new FizzBuzz19();

    @Test
    @Parameters({"1, 1", "2, 2", "Fizz, 3", "Buzz, 5", "Fizz, 6", "7, 7", "Fizz, 9", "Buzz, 10", "Fizz, 12",
            "FizzBuzz, 15", "FizzBuzz, 30"})
    public void printTest(String expected, int number) {
        assertEquals(expected, fizzBuzz19.print(number));
    }

    @Test(expected = RuntimeException.class)
    @Parameters({"0", "-1", "-20"})
    public void printCornerCaseLowerThan1Test(int number) {
        fizzBuzz19.print(number);
    }

    @Test(expected = RuntimeException.class)
    @Parameters({"101", "1000", "230"})
    public void printCornerCaseGreaterThan100Test(int number) {
        fizzBuzz19.print(number);
    }

}
