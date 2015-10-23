package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 23/10/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class BankAccountInterestTest5 {

    private BankAccountInterest5 bankAccountInterest5;

    @Before
    public void setUp() throws Exception {
        bankAccountInterest5 = new BankAccountInterest5();
    }

    @Test
    @Parameters(method = "getAmountBetween1And1000")
    public void getRightInterestWhenAmountIsBetween1And1000Test(int amount) {
        assertEquals(new BigDecimal("1.1"), bankAccountInterest5.getRightInterestForGivenAmount(amount));
    }

    public static final Object[] getAmountBetween1And1000() {
        return new Object[] {
                new Object[] {1},
                new Object[] {2},
                new Object[] {34},
                new Object[] {456},
                new Object[] {1000}
        };
    }

    @Test
    @Parameters(method = "getAmountBetween1001And2000")
    public void getRightInterestWhenAmountIsBetween1001And2000Test(int amount) {
        assertEquals(new BigDecimal("1.15"), bankAccountInterest5.getRightInterestForGivenAmount(amount));
    }

    public static final Object[] getAmountBetween1001And2000() {
        return new Object[] {
                new Object[] {1001},
                new Object[] {1500},
                new Object[] {2000}
        };
    }

    @Test
    @Parameters(method = "getAmountBetween2001And3000")
    public void getRightInterestWhenAmountIsBetween2001And3000Test(int amount) {
        assertEquals(new BigDecimal("1.22"), bankAccountInterest5.getRightInterestForGivenAmount(amount));
    }

    public static final Object[] getAmountBetween2001And3000() {
        return new Object[] {
                new Object[] {2001},
                new Object[] {2500},
                new Object[] {3000}
        };
    }

    @Test
    @Parameters(method = "getAmountGreaterThan3000")
    public void getRightInterestWhenAmountIsGreaterThan3000Test(int amount) {
        assertEquals(new BigDecimal("1.3"), bankAccountInterest5.getRightInterestForGivenAmount(amount));
    }

    public static final Object[] getAmountGreaterThan3000() {
        return new Object[] {
                new Object[] {3001},
                new Object[] {3500},
                new Object[] {4000}
        };
    }

    @Test(expected=RuntimeException.class)
    @Parameters(method = "getAmountEqualAndLessThan0")
    public void getRightInterestThrowExceptionWhenAmountIsZeroorLessTest(int amount) {
        bankAccountInterest5.getRightInterestForGivenAmount(amount);
    }

    public static final Object[] getAmountEqualAndLessThan0() {
        return new Object[] {
                new Object[] {0},
                new Object[] {-1},
                new Object[] {-100}
        };
    }





}
