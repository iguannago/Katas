package com.katas.bankAccountInterest;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class BankAccount11 {
    final private int amount;

    public BankAccount11(int amount) {
        this.amount = amount;
    }

    public static BankAccount11 of(int amount) {
        return new BankAccount11(amount);
    }

    public BigDecimal getInterest() {
        if (amount < 1)
            throw new IllegalArgumentException();
        if (amount > 3000)
            return new BigDecimal("1.3");
        if (amount > 2000)
            return new BigDecimal("1.22");
        if (amount >= 1001)
            return new BigDecimal("1.15");
        return new BigDecimal("1.1");
    }
}
