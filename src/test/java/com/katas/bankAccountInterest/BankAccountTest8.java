package com.katas.bankAccountInterest;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/07/2016.
 */
public class BankAccountTest8 {
    @Test
    public void given1Return1_1() {
        BankAccount8 bankAccount8 = new BankAccount8();
        assertEquals(bankAccount8.getInterest(1), new BigDecimal("1.1"));
    }

}
