package com.getinthecloud.katas.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BankAccountTest {

    private final RecordedDeposits recordedDeposits = mock(RecordedDeposits.class);
    private final RecordedWithdrawals recordedWithdrawals = mock(RecordedWithdrawals.class);
    private final Clock clock = Clock.fixed(Instant.parse("2022-01-01T00:00:00Z"), ZoneOffset.UTC);

    private final BankAccount bankAccount = new BankAccount(recordedDeposits, recordedWithdrawals, clock);

    @Test
    void startsWithAZeroBalance() {
        assertEquals(0, BigDecimal.ZERO.compareTo(bankAccount.balance()));
    }

    @Test
    void makePositiveDeposits() {
        bankAccount.deposit(BigDecimal.TEN);
        assertEquals(new BigDecimal("10.00"), bankAccount.balance());

        bankAccount.deposit(BigDecimal.ONE);
        assertEquals(new BigDecimal("11.00"), bankAccount.balance());

        bankAccount.deposit(BigDecimal.TWO);
        assertEquals(new BigDecimal("13.00"), bankAccount.balance());

        bankAccount.deposit(BigDecimal.ZERO);
        assertEquals(new BigDecimal("13.00"), bankAccount.balance());

        bankAccount.deposit(BigDecimal.ONE);
        assertEquals(new BigDecimal("14.00"), bankAccount.balance());

        bankAccount.deposit(new BigDecimal("10.500"));
        assertEquals(new BigDecimal("24.50"), bankAccount.balance());

        bankAccount.deposit(new BigDecimal("0.25"));
        assertEquals(new BigDecimal("24.75"), bankAccount.balance());
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
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(amount));
    }

    @ParameterizedTest
    @MethodSource("invalidAmounts")
    void rejectInvalidWithdrawalAmounts(BigDecimal amount) {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(amount));
    }

    @Test
    void withdrawValidAmounts() {
        bankAccount.deposit(BigDecimal.TEN);

        bankAccount.withdraw(BigDecimal.ONE);
        assertEquals(new BigDecimal("9.00"), bankAccount.balance());

        bankAccount.withdraw(BigDecimal.ONE);
        assertEquals(new BigDecimal("8.00"), bankAccount.balance());

        bankAccount.withdraw(new BigDecimal("0.10"));
        assertEquals(new BigDecimal("7.90"), bankAccount.balance());

        bankAccount.withdraw(new BigDecimal("0.00"));
        assertEquals(new BigDecimal("7.90"), bankAccount.balance());

        bankAccount.withdraw(new BigDecimal("7.90"));
        assertEquals(new BigDecimal("0.00"), bankAccount.balance());
    }

    @Test
    void rejectValidWithdrawalGreaterThanBalance() {
        bankAccount.deposit(BigDecimal.TEN);

        assertThrows(IllegalStateException.class, () -> bankAccount.withdraw(BigDecimal.valueOf(11)));
    }

    @Test
    void recordDatedDeposit() {
        LocalDateTime expectedDate = LocalDateTime.ofInstant(clock.instant(), clock.getZone());

        bankAccount.deposit(new BigDecimal("10.00"));
        bankAccount.deposit(new BigDecimal("10.00"));

        verify(recordedDeposits).add(argThat(deposit ->
                deposit != null
                        && expectedDate.equals(deposit.date())
                        && new BigDecimal("10.00")
                        .compareTo(deposit.balance()) == 0));

        verify(recordedDeposits).add(argThat(deposit ->
                deposit != null
                        && expectedDate.equals(deposit.date())
                        && new BigDecimal("20.00")
                        .compareTo(deposit.balance()) == 0));
    }

    @Test
    void recordDatedWithdrawal() {
        LocalDateTime expectedDate = LocalDateTime.ofInstant(clock.instant(), clock.getZone());

        bankAccount.deposit(new BigDecimal("10.00"));
        bankAccount.withdraw(new BigDecimal("1.00"));

        verify(recordedWithdrawals).add(argThat(withdrawal ->
                withdrawal != null
                        && expectedDate.equals(withdrawal.date())
                        && new BigDecimal("9.00")
                        .compareTo(withdrawal.balance()) == 0));
    }

}
