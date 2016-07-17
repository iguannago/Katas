package com.katas.bankAccountInterest;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/07/2016.
 */
public class BankAccountTest8 {

    private final BankAccount8 bankAccount8 = new BankAccount8();

    @Test
    public void given1Return1_1() {
        assertEquals(bankAccount8.getInterest(1), new BigDecimal("1.1"));
    }

    @Test
    public void given500Return1_1() {
        assertEquals(bankAccount8.getInterest(500), new BigDecimal("1.1"));
    }

    @Test
    public void given1000Return1_1() {
        assertEquals(bankAccount8.getInterest(1000), new BigDecimal("1.1"));
    }



}
