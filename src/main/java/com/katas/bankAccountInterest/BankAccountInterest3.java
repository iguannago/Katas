package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 30/04/2015.
 */
public class BankAccountInterest3 {
    public BigDecimal giveMeInterestOf(int i) {
        if (i >= 3001)
            return new BigDecimal("1.3");
        if (i >= 2001)
            return new BigDecimal("1.22");
        if (i >= 1001)
            return new BigDecimal("1.15");
        if (i < 0)
            throw new RuntimeException("Amount cannot be negative");
        return new BigDecimal("1.1");
    }
}
