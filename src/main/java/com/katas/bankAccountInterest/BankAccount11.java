package com.katas.bankAccountInterest;

import java.math.BigDecimal;

public class BankAccount11 {
    private BigDecimal interest;

    public BankAccount11(int amount) {
        interest = new BigDecimal("1.1");
    }

    public BigDecimal getInterest() {
        return interest;
    }
}
