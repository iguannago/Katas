package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 16/02/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest17 {

    private final FizzBuzz17 fizzBuzz17 = new FizzBuzz17();

    @Test
    @Parameters(method = "getAmountBetween1And100BothIncludedButNeverMultipleOf3OR5")
    public void whenNumberIsNot3OR5ThenPrintsNumber(int amountBetween1And100BothIncludedButNeverMultipleOf3Or5) {
        assertEquals(String.valueOf(amountBetween1And100BothIncludedButNeverMultipleOf3Or5),
                fizzBuzz17.printNumber(amountBetween1And100BothIncludedButNeverMultipleOf3Or5));
    }

    private static final Object[] getAmountBetween1And100BothIncludedButNeverMultipleOf3OR5() {
        return new Integer[][]{
                {1}, {2}, {4}, {7}, {11}
        };
    }

    @Test
    @Parameters(method = "getAmountMultipleOf3")
    public void whenNumberIsMultipleOf3ThenPrintsFizz(int amountMultipleOf3) {
        assertEquals("Fizz", fizzBuzz17.printNumber(amountMultipleOf3));
    }

    private static final Object[] getAmountMultipleOf3() {
        return new Integer[][]{
                {3}, {6}, {9}, {12}, {18}
        };
    }

    @Test
    @Parameters(method = "getAmountMultipleOf5")
    public void whenNumberIsMultipleOf5ThenPrintsBuzz(int amountMultipleOf5) {
        assertEquals("Buzz", fizzBuzz17.printNumber(amountMultipleOf5));
    }

    private static final Object[] getAmountMultipleOf5() {
        return new Integer[][]{
                {5}, {10}, {20}
        };
    }

    @Test
    @Parameters(method = "getAmountMultipleOf3And5")
    public void whenNumberIsMultipleOf3And5ThenPrintsBuzz(int amountMultipleOf3And5) {
        assertEquals("FizzBuzz", fizzBuzz17.printNumber(amountMultipleOf3And5));
    }

    private static final Object[] getAmountMultipleOf3And5() {
        return new Integer[][]{
                {15}, {30}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getAmountLowerThan1")
    public void whenNumberIsLowerThan0ThenThrowException(int amountLowerThan1) {
        fizzBuzz17.printNumber(amountLowerThan1);
    }

    private static final Object[] getAmountLowerThan1() {
        return new Integer[][]{
                {0}, {-1}, {-2}, {-123}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getAmountGreaterThan100")
    public void whenNumberIsGreaterThan100ThenThrowException(int amountGreaterThan100) {
        fizzBuzz17.printNumber(amountGreaterThan100);
    }

    private static final Object[] getAmountGreaterThan100() {
        return new Integer[][]{
                {101}, {150}, {123}
        };
    }



}
