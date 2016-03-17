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
    public void whenNumberIsNotMultipleOf3Or5ThenPrintsNumberTest(int contiguousNumberNotMultipleOf3Or5) {
        assertEquals(String.valueOf(contiguousNumberNotMultipleOf3Or5),
                fizzBuzzStep1.printFizzBuzz(contiguousNumberNotMultipleOf3Or5));
    }

    private static final Object[] getContiguousNumberNotMultipleOf3Or5() {
        return new Integer[][]{
                {1}, {2}, {4}, {7}, {8}, {11}, {14}, {17}
        };
    }

    @Test
    @Parameters(method = "getContiguousNumberMultipleOf3")
    public void whenNumberIsMultipleOf3ThenPrintsFizzTest(int contiguousNumberMultipleOf3) {
        assertEquals("fizz", fizzBuzzStep1.printFizzBuzz(contiguousNumberMultipleOf3));
    }

    private static final Object[] getContiguousNumberMultipleOf3() {
        return new Integer[][]{
                {6}, {9}, {12}, {18}, {27}
        };
    }

    @Test
    @Parameters(method = "getContiguousNumberMultipleOf5")
    public void whenNumberIsMultipleOf5ThenPrintsBuzzTest(int contiguousNumberMultipleOf5) {
        assertEquals("buzz", fizzBuzzStep1.printFizzBuzz(contiguousNumberMultipleOf5));
    }

    private static final Object[] getContiguousNumberMultipleOf5() {
        return new Integer[][]{
                {5}, {10}, {20}, {25}
        };
    }

    @Test
    @Parameters(method = "getContiguousNumberMultipleOf3And5")
    public void whenNumberIsMultipleOf3And5ThenPrintsFizzbuzzTest(int contiguousNumberMultipleOf3And5) {
        assertEquals("fizzbuzz", fizzBuzzStep1.printFizzBuzz(contiguousNumberMultipleOf3And5));
    }

    private static final Object[] getContiguousNumberMultipleOf3And5() {
        return new Integer[][]{
                {15}, {45}
        };
    }

    @Test
    @Parameters(method = "getNumberThatContains3")
    public void whenNumberContents3ThenPrintsLucky(int numberThatContains3) {
        assertEquals("lucky", fizzBuzzStep1.printFizzBuzz(numberThatContains3));
    }

    private static final Object[] getNumberThatContains3() {
        return new Integer[][]{
                {3}, {13}, {23}, {30}, {32}, {33}
        };
    }

    //TODO: check with customer for corner case such as when number is 0 or negative what is it the expected behaviour?

}
