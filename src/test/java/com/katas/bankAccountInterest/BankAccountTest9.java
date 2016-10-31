package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 31/10/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class BankAccountTest9 {

    private final BankAccount9 bankAccount9 = new BankAccount9();

    @Test
    @Parameters({"1", "2", "500", "1000"})
    public void givenAmountInterestIs1_1Test(int amount) {
        assertEquals(new BigDecimal("1.1"), bankAccount9.getInterest(amount));
    }

    @Test
    @Parameters({"1001", "1500", "2000"})
    public void givenAmountInterestIs1_15Test(int amount) {
        assertEquals(new BigDecimal("1.15"), bankAccount9.getInterest(amount));
    }

    @Test
    @Parameters({"2001", "2500", "3000"})
    public void givenAmountInterestIs1_22Test(int amount) {
        assertEquals(new BigDecimal("1.22"), bankAccount9.getInterest(amount));
    }

    @Test
    @Parameters({"3001", "3500", "4001"})
    public void givenAmountInterestIs1_3Test(int amount) {
        assertEquals(new BigDecimal("1.3"), bankAccount9.getInterest(amount));
    }

    @Test(expected = RuntimeException.class)
    @Parameters({"0", "-1"})
    public void givenAmountZeroOrLessReturnExceptionTest(int amount) {
        bankAccount9.getInterest(amount);
    }


}
