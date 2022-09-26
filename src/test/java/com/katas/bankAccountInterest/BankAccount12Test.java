package com.katas.bankAccountInterest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Exercise: Implement a function to get the right interest given an amount of money.
 * Given an amount in a range of [1-1000] the interest is  1.1%
 * Given an amount in a range of [1001 - 2000] the interest is  1.15%
 * Given an amount in a range of [2001 - 3000] the interest is 1.22%
 * Given an amount > 3000 then the interest is 1.3%
 *
 * Also given that:
 * customer wants for the amount to be a BigDecimal
 * customer wants to return an exception if the amount is negative
 */
public class BankAccount12Test {

    private final BankAccount12 bankAccount12 = new BankAccount12();

    @ParameterizedTest
    @CsvSource(value = {
        "1", "2", "100", "300", "1000"
    })
    void whenAmountBetween1And1000ThenReturn1_1Interest(int amount) {
        BigDecimal actualInterest = bankAccount12.getInterest(amount);
        assertEquals(new BigDecimal("1.1"), actualInterest);
    }

    @Test
    void whenAmountIsZeroThenReturnException() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount12.getInterest(0));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1001", "1100", "1999", "2000"
    })
    void whenAmountBetween1001And200ThenReturn1_15Interest(int amount) {
        BigDecimal actualInterest = bankAccount12.getInterest(amount);
        assertEquals(new BigDecimal("1.15"), actualInterest);
    }
}
