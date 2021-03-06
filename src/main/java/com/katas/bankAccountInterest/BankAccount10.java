package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 29/12/2016.
 */
public class BankAccount10 {
    public BigDecimal getInterest(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount cannot be Zero or Less");
        }
        if (amount > 3000) {
            return new BigDecimal("1.3");
        }
        if (amount > 2000) {
            return new BigDecimal("1.22");
        }
        if (amount > 1000) {
            return new BigDecimal("1.15");
        }
        return new BigDecimal("1.1");
    }
}
