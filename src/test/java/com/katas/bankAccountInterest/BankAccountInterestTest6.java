package com.katas.bankAccountInterest;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 29/12/2015.
 */
public class BankAccountInterestTest6 {

    @Test
    public void given1ThenReturns1_1() {
        BankAccountInterest6 bankAccountInterest6 = new BankAccountInterest6();
        BigDecimal interest = bankAccountInterest6.getRightInterest(1);
        assertEquals(new BigDecimal("1.1"), interest);
    }
}
