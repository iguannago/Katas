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
    @Parameters({"1, 1", "3, Fizz"})
    public void when1Print1(int input, String expected) throws Exception {
        assertEquals(expected, fizzBuzz22.print(input));
    }

}
