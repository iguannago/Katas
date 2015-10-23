package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 23/10/2015.
 */
public class BankAccountInterest5 {
    public BigDecimal getRightInterestForGivenAmount(int i) {
        if (i <= 0)
            throw new RuntimeException();
        if (i > 3000)
            return new BigDecimal("1.3");
        if (i > 2000)
            return new BigDecimal("1.22");
        if (i > 1000)
            return new BigDecimal("1.15");
        return new BigDecimal("1.1");
    }
}
