package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 21/06/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class BankAccountTest7 {

    private final BankAccount7 bankAccount = new BankAccount7();

    @Test
    @Parameters(method = "getAmountBetween1And1000")
    public void getInterestReturns1_1WhenAmountIsBetween1And1000Test(int amountBetween1And1000) {
        assertEquals(new BigDecimal("1.1"), bankAccount.getInterest(amountBetween1And1000));
    }

    private static final Object[] getAmountBetween1And1000() {
        return new Integer[][]{
                {1}, {200}, {456}, {1000}
        };
    }

    @Test
    @Parameters(method = "getAmountBetween1001And2000")
    public void getInterestReturns1_15WhenAmountIsBetween1001And2000Test(int amountBetween1001And2000) {
        assertEquals(new BigDecimal("1.15"), bankAccount.getInterest(amountBetween1001And2000));
    }

    private static final Object[] getAmountBetween1001And2000() {
        return new Integer[][]{
                {1001}, {1345}, {2000}
        };
    }

    @Test
    @Parameters(method = "getAmountBetween2001And3000")
    public void getInterestReturns1_22WhenAmountIsBetween2001And3000Test(int amountBetween2001And3000) {
        assertEquals(new BigDecimal("1.22"), bankAccount.getInterest(amountBetween2001And3000));
    }

    private static final Object[] getAmountBetween2001And3000() {
        return new Integer[][]{
                {2001}, {2345}, {3000}
        };
    }



}
