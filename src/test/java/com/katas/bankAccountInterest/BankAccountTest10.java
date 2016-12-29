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

    @Test
    public void whenAmountIs1001ThenInterestIs1_15() throws Exception {
        assertEquals(new BigDecimal("1.15"), bankAccount10.getInterest(1001));
    }
}
