package com.katas.bankAccountInterest;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankAccountInterestTest11 {
    @Test
    public void whenAmountIs1ThenInterestIs1_1Test() throws Exception {
        BankAccount11 bankAccount11 = new BankAccount11(1);
        assertEquals(new BigDecimal("1.1"), bankAccount11.getInterest());
    }
}
