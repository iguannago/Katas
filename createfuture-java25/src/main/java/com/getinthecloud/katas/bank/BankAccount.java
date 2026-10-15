package com.getinthecloud.katas.bank;

import java.math.BigDecimal;

public final class BankAccount {

    private BigDecimal balance;

    public BankAccount() {
        this.balance = BigDecimal.ZERO;
    }

    public BigDecimal balance() {
        //noinspection BigDecimalMethodWithoutRoundingCalled
        return balance.setScale(2);
    }

    public void deposit(BigDecimal amount) {
        validateAmount(amount);
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        validateAmount(amount);
        balance = balance.subtract(amount);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        try {
            //noinspection BigDecimalMethodWithoutRoundingCalled,ResultOfMethodCallIgnored
            amount.setScale(2);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }
}
