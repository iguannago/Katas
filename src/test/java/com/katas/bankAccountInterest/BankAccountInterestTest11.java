package com.katas.bankAccountInterest;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankAccountInterestTest11 {
    @Test
    public void whenAmountIs1ThenInterestIs1_1Test() throws Exception {
        assertEquals(new BigDecimal("1.1"), BankAccount11.of(1).getInterest());
    }

    @Test
    public void whenAmountIs2ThenInterestIs1_1Test() throws Exception {
        assertEquals(new BigDecimal("1.1"), BankAccount11.of(2).getInterest());
    }

    @Test
    public void whenAmountis1000ThenInterestIs1_1Test() throws Exception {
        assertEquals(new BigDecimal("1.1"), BankAccount11.of(1000).getInterest());
    }
}
