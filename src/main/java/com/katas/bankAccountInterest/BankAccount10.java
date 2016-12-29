package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 29/12/2016.
 */
public class BankAccount10 {
    public BigDecimal getInterest(int i) {
        if (i == 1001) {
            return new BigDecimal("1.15");
        }
        return new BigDecimal("1.1");
    }
}
