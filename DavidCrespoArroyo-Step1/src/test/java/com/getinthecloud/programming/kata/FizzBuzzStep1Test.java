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
    @Parameters(method = "getContiguousNumberNotMultipleOf3Or5")
    public void whenNumberIsNotMultipleOf3Or5ThenPrintsNumber(int contiguousNumberNotMultipleOf3Or5) {
        assertEquals(String.valueOf(contiguousNumberNotMultipleOf3Or5),
                fizzBuzzStep1.printFizzBuzz(contiguousNumberNotMultipleOf3Or5));
    }

    private static final Object[] getContiguousNumberNotMultipleOf3Or5() {
        return new Integer[][]{
                {1}, {2}, {4}, {7}, {8}, {11}, {13}, {14}, {17}
        };
    }

    @Test
    public void whenNumberIsMultipleOf3ThenPrintsFizz() {
        assertEquals("fizz", fizzBuzzStep1.printFizzBuzz(3));
    }




}
