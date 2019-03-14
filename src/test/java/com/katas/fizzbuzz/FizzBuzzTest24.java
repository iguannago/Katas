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
    @Parameters({"1,1", "2,2", "Fizz,3", "4,4", "Buzz,5", "Fizz,6", "7,7", "Fizz,9", "Buzz,10", "11,11", "Fizz,12",
            "FizzBuzz, 15", "FizzBuzz,30"})
    public void givenNumber_shouldPrintNumberOrFizzOrBuzzOrFizzBuzz1(String expected, int number) {
        assertEquals(expected, fizzBuzz24.print(number));
    }

    @Test(expected = RuntimeException.class)
    @Parameters({"0", "-1", "101", "201"})
    public void givenNumberOutOfBoundaries_shouldThrowException(int number) {
        fizzBuzz24.print(number);
    }
}
