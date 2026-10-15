package com.getinthecloud.katas.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    @Test
    void startsWithAZeroBalance() {
        assertEquals(0, BigDecimal.ZERO.compareTo(new BankAccount().balance()));
    }

    @Test
    void makePositiveDeposits() {
        BankAccount account = new BankAccount();
        account.deposit(BigDecimal.TEN);
        assertEquals(new BigDecimal("10"), account.balance());

        account.deposit(BigDecimal.ONE);
        assertEquals(new BigDecimal("11"), account.balance());

        account.deposit(BigDecimal.TWO);
        assertEquals(new BigDecimal("13"), account.balance());

        account.deposit(BigDecimal.ZERO);
        assertEquals(new BigDecimal("13"), account.balance());

        account.deposit(BigDecimal.ONE);
        assertEquals(new BigDecimal("14"), account.balance());
    }

    @Test
    void withdrawValidAmounts() {
        BankAccount account = new BankAccount();
        account.deposit(BigDecimal.TEN);

        account.withdraw(BigDecimal.ONE);
        assertEquals(new BigDecimal("9"), account.balance());

        account.withdraw(BigDecimal.ONE);
        assertEquals(new BigDecimal("8"), account.balance());
    }
}
