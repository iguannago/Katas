package com.katas.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 30/06/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest18 {

    private final FizzBuzz18 fizzBuzz18 = new FizzBuzz18();

    @Test
    @Parameters(method = "getValues")
    public void when1Prints1Test(int values) {
        assertEquals(String.valueOf(values), fizzBuzz18.print(values));
    }

    private static final Object[] getValues() {
        return new Integer[][]{
                {1}, {2}
        };
    }



}
