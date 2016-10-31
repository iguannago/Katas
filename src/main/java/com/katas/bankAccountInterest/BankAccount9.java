package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 31/10/2016.
 */
public class BankAccount9 {
    public BigDecimal getInterest(int amount) {
        if (amount > 2000) {
            return new BigDecimal("1.22");
        }
        if (amount > 1000) {
            return new BigDecimal("1.15");
        }
        return new BigDecimal("1.1");
    }
}
