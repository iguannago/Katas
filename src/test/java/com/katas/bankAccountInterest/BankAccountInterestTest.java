package com.katas.bankAccountInterest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Exercise: Implement a function to get the right interest given an amount of money.
 * Given an amount in a range of [0-1000] the interest is  1.1%
 * Given an amount in a range of [1001 - 2000] the interest is  1.15%
 * Given an amount in a range of [2001 - 3000] the interest is 1.22%
 * Given an amount > 3000 then the interest is 1.3%
 */
public class BankAccountInterestTest {

    private BankAccount bankAccount;

    @Before
    public void setUp() throws Exception {
        bankAccount = new BankAccount();
    }

    @Test(expected = RuntimeException.class)
    public void givenLessThan0ThrowException() {
        bankAccount.getInterest(new BigDecimal("-1"));
    }

    @Test
    public void given0Return1_1() {
        Assert.assertEquals("Interest should be 1.1%", BankAccount.INTEREST_1_1,
                bankAccount.getInterest(new BigDecimal("0")));
    }

    @Test
    public void given1000Return1_1() {
        Assert.assertEquals("Interest should be 1.1%", BankAccount.INTEREST_1_1,
                bankAccount.getInterest(new BigDecimal("1000")));
    }

    @Test
    public void given500Return1_1() {
        Assert.assertEquals("Interest should be 1.1%", BankAccount.INTEREST_1_1,
                bankAccount.getInterest(new BigDecimal("500")));
    }

    @Test
    public void given1001Return1_15() {
        Assert.assertEquals("Interest should be 1.15%", BankAccount.INTEREST_1_15,
                bankAccount.getInterest(new BigDecimal("1001")));
    }

    @Test
    public void given2000Return1_15() {
        Assert.assertEquals("Interest should be 1.15%", BankAccount.INTEREST_1_15,
                bankAccount.getInterest(new BigDecimal("2000")));
    }

    @Test
    public void given1500Return1_15() {
        Assert.assertEquals("Interest should be 1.15%", BankAccount.INTEREST_1_15,
                bankAccount.getInterest(new BigDecimal("1500")));
    }

    @Test
    public void given2001Return1_22() {
        Assert.assertEquals("Interest should be 1.22%", BankAccount.INTEREST_1_22,
                bankAccount.getInterest(new BigDecimal("2001")));
    }

    @Test
    public void given3000Return1_22() {
        Assert.assertEquals("Interest should be 1.22%", BankAccount.INTEREST_1_22,
                bankAccount.getInterest(new BigDecimal("3000")));
    }

    @Test
    public void given2999Return1_22() {
        Assert.assertEquals("Interest should be 1.22%", BankAccount.INTEREST_1_22,
                bankAccount.getInterest(new BigDecimal("2999")));
    }

    @Test
    public void given3001Return1_3() {
        Assert.assertEquals("Interest should be 1.3%", BankAccount.INTEREST_1_3,
                bankAccount.getInterest(new BigDecimal("3001")));
    }

}
