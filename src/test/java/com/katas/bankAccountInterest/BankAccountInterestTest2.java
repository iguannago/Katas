package com.katas.bankAccountInterest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by davicres on 23/09/2014.
 * /**
 * Exercise: Implement a function to get the right interest given an amount of money.
 * Given an amount in a range of [0-1000] the interest is  1.1%
 * Given an amount in a range of [1001 - 2000] the interest is  1.15%
 * Given an amount in a range of [2001 - 3000] the interest is 1.22%
 * Given an amount > 3000 then the interest is 1.3%
 * <p/>
 * Also given that:
 * customer wants for the amount to be a BigDecimal
 * customer wants to return an exception if the amount is negative
 */
public class BankAccountInterestTest2 {

    private BankAccount2 bankAccount2;

    @Before
    public void setUp() throws Exception {
        bankAccount2 = new BankAccount2();
    }

    @Test
    public void given0TheInterestIs1_1Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_ONE, bankAccount2.getRightInterest(new BigDecimal("0")));
    }

    @Test
    public void given1TheInterestIs1_1Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_ONE, bankAccount2.getRightInterest(new BigDecimal("1")));
    }

    @Test
    public void given2TheInterestIs1_1Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_ONE, bankAccount2.getRightInterest(new BigDecimal("2")));
    }

    @Test
    public void given1000TheInterestIs1_1Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_ONE, bankAccount2.getRightInterest(new BigDecimal("1000")));
    }

    @Test
    public void given1001TheInterestIs1_15Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_FIFTEEN, bankAccount2.getRightInterest(new BigDecimal("1001")));
    }

    @Test
    public void given1002TheInterestIs1_15Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_FIFTEEN, bankAccount2.getRightInterest(new BigDecimal("1002")));
    }

    @Test
    public void given2000TheInterestIs1_15Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_FIFTEEN, bankAccount2.getRightInterest(new BigDecimal("2000")));
    }

    @Test
    public void given2001TheInterestIs1_22Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_TWENTY_TWO, bankAccount2.getRightInterest(new BigDecimal("2001")));
    }

    @Test
    public void given2050TheInterestIs1_22Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_TWENTY_TWO, bankAccount2.getRightInterest(new BigDecimal("2050")));
    }

    @Test
    public void given3000TheInterestIs1_22Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_TWENTY_TWO, bankAccount2.getRightInterest(new BigDecimal("3000")));
    }

    @Test
    public void given3001TheInterestIs1_3Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_THREE, bankAccount2.getRightInterest(new BigDecimal("3001")));
    }

    @Test
    public void given4001TheInterestIs1_3Test() {
        Assert.assertEquals(BankAccount2.ONE_POINT_THREE, bankAccount2.getRightInterest(new BigDecimal("4001")));
    }

    /**
     * no happy paths: When amount is negative return exception
     */

    @Test(expected = RuntimeException.class)
    public void givenNegativeAmountThrowExceptionTest() {
        bankAccount2.getRightInterest(new BigDecimal("-1"));
    }


}
