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

    @Test
    @Parameters({"1, 1", "2, 2", "3, Fizz", "4, 4", "5, Buzz", "6, Fizz", "7, 7", "9, Fizz"})
    public void when1Prints1Test(int input, String expected) {
        FizzBuzz21 fizzBuzz21 = new FizzBuzz21();
        String actual = fizzBuzz21.print(input);
        assertEquals(expected, actual);
    }


}
