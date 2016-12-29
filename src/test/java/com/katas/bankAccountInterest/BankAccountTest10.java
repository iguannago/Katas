package com.katas.bankAccountInterest;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 29/12/2016.
 */
public class BankAccountTest10 {
    @Test
    public void whenAmountIs1ThenInterestIs1_1() throws Exception {
        BankAccount10 bankAccount10 = new BankAccount10();
        BigDecimal interest = bankAccount10.getInterest(1);
        assertEquals(new BigDecimal("1.1"), interest);
    }
}
