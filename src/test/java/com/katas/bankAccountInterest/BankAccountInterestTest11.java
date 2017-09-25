package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BankAccountInterestTest11 {
    @Test
    @Parameters({"1", "23", "1000"})
    public void whenAmountIsSomethingBetween1And1000IncludedThenInterestIs1_1Test(int amount) throws Exception {
        assertEquals(new BigDecimal("1.1"), BankAccount11.of(amount).getInterest());
    }

    @Test
    @Parameters({"1001", "1500", "2000"})
    public void whenAmountIsSomethingBetween1001And2000IncludedThenInterestIs1_15Test(int amount) throws Exception {
        assertEquals(new BigDecimal("1.15"), BankAccount11.of(amount).getInterest());
    }

    @Test
    @Parameters({"2001", "2500", "3000"})
    public void whenAmountIsSomethingBetween2001And3000IncludedThenInterestIs1_22Test(int amount) throws Exception {
        assertEquals(new BigDecimal("1.22"), BankAccount11.of(amount).getInterest());
    }

    @Test
    @Parameters({"3001", "3400"})
    public void whenAmountIsGreaterThan3000ThenInterestIs1_3Test(int amount) throws Exception {
        assertEquals(new BigDecimal("1.3"), BankAccount11.of(amount).getInterest());
    }

    //Corner cases
    @Test(expected = IllegalArgumentException.class)
    @Parameters({"0", "-1"})
    public void whenAmountIsLowerThan1ThenThrowExceptionTest(int amount) throws Exception {
        BankAccount11.of(amount).getInterest();
    }

}

