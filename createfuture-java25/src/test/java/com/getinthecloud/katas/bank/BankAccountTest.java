package com.getinthecloud.katas.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    @Test
    void startsWithAZeroBalance() {
        assertEquals(0, BigDecimal.ZERO.compareTo(new BankAccount().balance()));
    }
}
