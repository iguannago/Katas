package com.getinthecloud.katas.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void startsWithAZeroBalance() {
        assertEquals(0, BigDecimal.ZERO.compareTo(new BankAccount().balance()));
    }

    @Test
    void makePositiveDeposits() {
        BankAccount account = new BankAccount();
        account.deposit(BigDecimal.TEN);
        assertEquals(new BigDecimal("10.00"), account.balance());

        account.deposit(BigDecimal.ONE);
        assertEquals(new BigDecimal("11.00"), account.balance());

        account.deposit(BigDecimal.TWO);
        assertEquals(new BigDecimal("13.00"), account.balance());

        account.deposit(BigDecimal.ZERO);
        assertEquals(new BigDecimal("13.00"), account.balance());

        account.deposit(BigDecimal.ONE);
        assertEquals(new BigDecimal("14.00"), account.balance());

        account.deposit(new BigDecimal("10.500"));
        assertEquals(new BigDecimal("24.50"), account.balance());
    }

    public static Stream<Arguments> invalidAmounts() {
        return Stream.<Arguments>builder()
                .add(Arguments.of((Object) null))
                .add(Arguments.of(new BigDecimal("-1")))
                .add(Arguments.of(new BigDecimal("-10")))
                .add(Arguments.of(new BigDecimal("10.001")))
                .add(Arguments.of(new BigDecimal("10.501")))
                .build();
    }

    @ParameterizedTest
    @MethodSource("invalidAmounts")
    void rejectInvalidDepositAmounts(BigDecimal amount) {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount().deposit(amount));
    }

    @ParameterizedTest
    @MethodSource("invalidAmounts")
    void rejectInvalidWithdrawalAmounts(BigDecimal amount) {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount().withdraw(amount));
    }

    @Test
    void withdrawValidAmounts() {
        BankAccount account = new BankAccount();
        account.deposit(BigDecimal.TEN);

        account.withdraw(BigDecimal.ONE);
        assertEquals(new BigDecimal("9.00"), account.balance());

        account.withdraw(BigDecimal.ONE);
        assertEquals(new BigDecimal("8.00"), account.balance());
    }
}
