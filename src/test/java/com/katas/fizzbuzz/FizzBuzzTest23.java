package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 05/04/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest23 {

    private FizzBuzz23 fizzBuzz23 = new FizzBuzz23();

    @Test
    @Parameters({"1,1", "2,2", "Fizz, 3", "4, 4", "Buzz, 5"})
    public void givenNumberPrintFizzBuzz(String expected, int number) throws Exception {
        assertEquals(expected, fizzBuzz23.print(number));
    }
}
