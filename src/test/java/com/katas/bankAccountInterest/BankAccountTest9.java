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
    @Parameters({"2001"})
    public void givenAmountInterestIs1_22Test(int amount) {
        assertEquals(new BigDecimal("1.22"), bankAccount9.getInterest(amount));
    }


}
