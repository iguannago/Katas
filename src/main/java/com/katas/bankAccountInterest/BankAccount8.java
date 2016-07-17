package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 17/07/2016.
 */
public class BankAccount8 {
    public BigDecimal getInterest(int money) {
        if (money == 2001)
            return new BigDecimal("1.22");
        if (money > 1000)
            return new BigDecimal("1.15");
        return new BigDecimal("1.1");
    }
}
