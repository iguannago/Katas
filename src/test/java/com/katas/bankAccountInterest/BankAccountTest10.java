package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 29/12/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class BankAccountTest10 {

    private final BankAccount10 bankAccount10 = new BankAccount10();

    @Parameters({"1", "2", "1000"})
    @Test
    public void whenAmountIsBetween1And1000ThenInterestIs1_1(int amount) throws Exception {
        assertEquals(new BigDecimal("1.1"), bankAccount10.getInterest(amount));
    }

    @Parameters({"1001", "1002", "2000"})
    @Test
    public void whenAmountBetween1001And2000ThenInterestIs1_15(int amount) throws Exception {
        assertEquals(new BigDecimal("1.15"), bankAccount10.getInterest(amount));
    }

    @Parameters({"2001", "2002", "3000"})
    @Test
    public void whenAmountBetween2001And3000ThenInterestIs1_22(int amount) throws Exception {
        assertEquals(new BigDecimal("1.22"), bankAccount10.getInterest(amount));
    }

    @Parameters({"3001", "3002", "3100"})
    @Test
    public void whenAmountIsGreaterThan3000ThenInterestIs1_2(int amount) {
        assertEquals(new BigDecimal("1.3"), bankAccount10.getInterest(amount));
    }

//    Corner cases

    @Parameters({"0"})
    @Test(expected = IllegalArgumentException.class)
    public void whenAmountIsZeroOrLessThenThrowException(int amount) throws Exception {
        bankAccount10.getInterest(amount);
    }
}
