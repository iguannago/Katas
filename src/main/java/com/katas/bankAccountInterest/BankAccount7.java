package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 21/06/2016.
 */
public class BankAccount7 {
    public BigDecimal getInterest(int amount) {
        if (amount > 1000)
            return new BigDecimal("1.15");
        return new BigDecimal("1.1");
    }
}
