package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 29/12/2015.
 */
public class BankAccountInterest6 {
    public BigDecimal getRightInterest(int interest) {
        if (interest <= 0)
            throw new IllegalArgumentException();
        if (interest > 3000)
            return new BigDecimal("1.3");
        if (interest > 2000)
            return new BigDecimal("1.22");
        if (interest > 1000)
            return new BigDecimal("1.15");
        return new BigDecimal("1.1");
    }
}
