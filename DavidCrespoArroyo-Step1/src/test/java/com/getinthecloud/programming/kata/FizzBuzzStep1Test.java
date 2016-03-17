package com.getinthecloud.programming.kata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/03/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzStep1Test {

    private final FizzBuzzStep1 fizzBuzzStep1 = new FizzBuzzStep1();

    @Test
    @Parameters(method = "getContiguousNumber")
    public void whenNumberPrintsFizzBuzzOrNumber(int contiguousNumber) {
        assertEquals(String.valueOf(contiguousNumber), fizzBuzzStep1.printFizzBuzz(contiguousNumber));
    }

    private static final Object[] getContiguousNumber() {
        return new Integer[][]{
                {1}, {2}
        };
    }




}
