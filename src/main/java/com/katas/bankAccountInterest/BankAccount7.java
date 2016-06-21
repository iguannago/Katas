package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 21/06/2016.
 */
public class BankAccount7 {
    public BigDecimal getInterest(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("zero is not a valid amount");
        if (amount > 3000)
            return new BigDecimal("1.3");
        if (amount > 2000)
            return new BigDecimal("1.22");
        if (amount > 1000)
            return new BigDecimal("1.15");
        return new BigDecimal("1.1");
    }
}
