package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 17/07/2016.
 */
public class BankAccount8 {
    public BigDecimal getInterest(int money) {
        if (money <= 0)
            throw new RuntimeException("money cannot be zero");
        if (money > 3000)
            return new BigDecimal("1.3");
        if (money > 2000)
            return new BigDecimal("1.22");
        if (money > 1000)
            return new BigDecimal("1.15");
        return new BigDecimal("1.1");
    }
}
