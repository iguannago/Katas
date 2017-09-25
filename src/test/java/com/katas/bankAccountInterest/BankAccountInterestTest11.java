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
}

