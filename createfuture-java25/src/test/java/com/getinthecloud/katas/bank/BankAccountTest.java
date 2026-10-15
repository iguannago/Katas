package com.getinthecloud.katas.bank;

import java.math.BigDecimal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Remove after FizzBuzz to begin the bank account exercise")
class BankAccountTest {

    @Test
    void startsWithAZeroBalance() {
        assertEquals(0, BigDecimal.ZERO.compareTo(new BankAccount().balance()));
    }
}
