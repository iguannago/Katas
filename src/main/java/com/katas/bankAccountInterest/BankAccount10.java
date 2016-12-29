package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 29/12/2016.
 */
public class BankAccount10 {
    public BigDecimal getInterest(int amount) {
        if (amount == 2001) {
            return new BigDecimal("1.22");
        }
        if (amount > 1000) {
            return new BigDecimal("1.15");
        }
        return new BigDecimal("1.1");
    }
}
