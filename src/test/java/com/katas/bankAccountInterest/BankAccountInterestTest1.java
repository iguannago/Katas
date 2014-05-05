package com.katas.bankAccountInterest;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 05/05/2014.
 */
public class BankAccountInterestTest1 {

    public static final String INTEREST_IS_NOT_1_1 = "interest is not 1.1%";
    public static final BigDecimal BIG_DECIMAL_1_1 = new BigDecimal("1.1");
    public static final String INTEREST_IS_NOT_1_15 = "Interest is not 1.15%";
    public static final BigDecimal BIG_DECIMAL_1_15 = new BigDecimal("1.15");
    private BankAccount1 bankAccount1;

    @Before
    public void setUp() throws Exception {
        bankAccount1 = new BankAccount1();
    }

    // 1. Given an amount in a range of [0-1000] the interest is 1.1%
    // Testing happy path
    @Test
    public void givenAmountOf500Returns1_1() {
        assertEquals(INTEREST_IS_NOT_1_1, BIG_DECIMAL_1_1, bankAccount1.workOutInterest(500));
    }

    // Testing ambiguous cases
    // If amount is 0 then return interest 1.1 (This is a customer decision)
    @Test
    public void givenAmountOf0Returns1_1() {
        assertEquals(INTEREST_IS_NOT_1_1, BIG_DECIMAL_1_1, bankAccount1.workOutInterest(0));
    }

    // If amount is 1000 then return interest 1.1 (This is a customer decision)
    @Test
    public void givenAmountOf1000Returns1_1() {
        assertEquals(INTEREST_IS_NOT_1_1, BIG_DECIMAL_1_1, bankAccount1.workOutInterest(1000));
    }

    // 2. Given an amount in a range of [1001 - 2000] the interest is 1.15%
    // Testing happy path
    @Test
    public void givenAmountOf1500Returns1_15() {
        assertEquals(INTEREST_IS_NOT_1_15, BIG_DECIMAL_1_15, bankAccount1.workOutInterest(1500));
    }

    // Testing ambiguous cases
    // If amount is 1001 then return interest 1.15 (This is a customer decision)
    @Test
    public void givenAmountOf1001Returns1_15() {
        assertEquals(INTEREST_IS_NOT_1_15, BIG_DECIMAL_1_15, bankAccount1.workOutInterest(1001));
    }

    // If amount is 2000 then return interest 1.15 (This is a customer decision)
    @Test
    public void givenAmountOf2000Returns1_15() {
        assertEquals(INTEREST_IS_NOT_1_15, BIG_DECIMAL_1_15, bankAccount1.workOutInterest(2000));
    }

    // 2. Given an amount > 2000 then the interest is 1.3%
    // Testing happy path
    @Test
    public void givenAmountOf2001Returns1_3() {
        assertEquals("Interest is not 1.3%", new BigDecimal("1.3"), bankAccount1.workOutInterest(2001));
    }

    //Testing ambiguous cases
    //If amount is negative then return exception
    @Test(expected = RuntimeException.class)
    public void givenNegativeAmountThrowsException() {
        bankAccount1.workOutInterest(-1);
    }

}
