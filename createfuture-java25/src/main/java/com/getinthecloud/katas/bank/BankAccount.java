package com.getinthecloud.katas.bank;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public final class BankAccount {

    private BigDecimal balance;
    private final RecordedDeposits recordedDeposits;
    private final RecordedWithdrawals recordedWithdrawals;
    private final Clock clock;

    public BankAccount(RecordedDeposits recordedDeposits, RecordedWithdrawals recordedWithdrawals, Clock clock) {
        this.recordedDeposits = recordedDeposits;
        this.recordedWithdrawals = recordedWithdrawals;
        this.clock = clock;
        this.balance = BigDecimal.ZERO;
    }

    public BigDecimal balance() {
        //noinspection BigDecimalMethodWithoutRoundingCalled
        return balance.setScale(2);
    }

    public void deposit(BigDecimal amount) {
        validateAmount(amount);
        balance = balance.add(amount);
        recordedDeposits.add(new Deposit(LocalDateTime.now(clock), balance));
    }

    public void withdraw(BigDecimal amount) {
        validateAmount(amount);
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance = balance.subtract(amount);
        recordedWithdrawals.add(new Withdrawal(LocalDateTime.now(clock), balance));
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid deposit balance");
        }
        try {
            //noinspection BigDecimalMethodWithoutRoundingCalled,ResultOfMethodCallIgnored
            amount.setScale(2);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Invalid deposit balance");
        }
    }
}
