package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 30/06/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest18 {

    private final FizzBuzz18 fizzBuzz18 = new FizzBuzz18();

    @Test
    @Parameters(method = "getValues")
    public void printMethodTest(int values, String expectedResult) {
        assertEquals(expectedResult, fizzBuzz18.print(values));
    }

    private Object[] getValues() {
        return $(
                $(1, "1"),
                $(2, "2"),
                $(3, "Fizz"),
                $(4, "4"),
                $(5, "Buzz"),
                $(6, "Fizz"),
                $(7, "7"),
                $(8, "8"),
                $(9, "Fizz"),
                $(10, "Buzz"),
                $(11, "11"),
                $(15, "FizzBuzz")
        );
    }

    //corner cases
    @Test(expected = IllegalArgumentException.class)
    public void whenLessThan1ThenException() {
        fizzBuzz18.print(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenGreaterThan100ThenException() {
        fizzBuzz18.print(101);
    }





}
