package com.katas.fizzbuzz;

import static org.junit.Assert.assertEquals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest24 {

    private final FizzBuzz24 fizzBuzz24 = new FizzBuzz24();

    @Test
    @Parameters({"1,1", "2,2", "Fizz,3", "4,4", "Buzz,5"})
    public void given1_shouldReturn1(String expected, int number) {
        assertEquals(expected, fizzBuzz24.print(number));
    }

}
