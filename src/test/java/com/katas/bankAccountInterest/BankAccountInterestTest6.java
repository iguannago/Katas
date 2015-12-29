package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 29/12/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class BankAccountInterestTest6 {

    private BankAccountInterest6 bankAccountInterest6;

    @Before
    public void setUp() throws Exception {
        bankAccountInterest6 = new BankAccountInterest6();
    }

    @Test
    @Parameters(method = "getAmountBetween1And1000BothIncluded")
    public void givenAnAmountBetween1And1000BothIncludedThenReturns1_1InterestTest(int amountBetween1And1000) {
        assertEquals(new BigDecimal("1.1"), bankAccountInterest6.getRightInterest(amountBetween1And1000));
    }

    private static final Object[] getAmountBetween1And1000BothIncluded() {
        return new Integer[][]{
                {1}, {234}, {500}, {1000}
        };
    }

    @Test
    @Parameters(method = "getAmountBetween1001And2000")
    public void givenAnAmountBetween1001And2000BothIncludedThenReturns1_15InterestTest(int amountBetween1001And2000) {
        assertEquals(new BigDecimal("1.15"), bankAccountInterest6.getRightInterest(amountBetween1001And2000));

    }

    private static final Object[] getAmountBetween1001And2000() {
        return new Integer[][]{
                {1001}, {1120}, {2000}
        };
    }

    @Test
    @Parameters(method = "getAmountBetween2001And3000")
    public void givenAnAmountBetween2001And3000BothIncludedThenReturns1_22InterestTest(int amountBetween2001And3000) {
        assertEquals(new BigDecimal("1.22"), bankAccountInterest6.getRightInterest(amountBetween2001And3000));
    }

    private static final Object[] getAmountBetween2001And3000() {
        return new Integer[][] {
                {2001}, {2345}, {3000}
        };
    }

    @Test
    @Parameters(method = "getAmountGreaterThan3000")
    public void givenAnAmountGreaterThan3000ThenReturns1_3InterestTest(int amountGreaterThan3000) {
        assertEquals(new BigDecimal("1.3"), bankAccountInterest6.getRightInterest(amountGreaterThan3000));
    }

    private static final Object[] getAmountGreaterThan3000() {
        return new Integer[][] {
                {3001}, {3874}, {10000983}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getAmountZeroOrLessThanZero")
    public void givenAnAmountOfZeroOrLessThanZeroThenReturnsExceptionTest(int amountZeroOrLessThanZero) {
        bankAccountInterest6.getRightInterest(amountZeroOrLessThanZero);
    }

    private static final Object[] getAmountZeroOrLessThanZero() {
        return new Integer[][]{
                {0}, {-1}, {-1213}
        };
    }
}
