package com.katas.bankAccountInterest;

import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class BankAccount11 {
    final private int amount;

    public BigDecimal getInterest() {
        return new BigDecimal("1.1");
    }
}
