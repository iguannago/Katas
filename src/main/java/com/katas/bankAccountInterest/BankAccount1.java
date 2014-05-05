package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 05/05/2014.
 */
public class BankAccount1 {
    public BigDecimal workOutInterest(int amount) {
        if (equalOrBiggerThan0AndEqualOrLessThan1000(amount)) {
            return new BigDecimal("1.1");
        }
        if (equalOrBiggerThan1001AndEqualOrLessThan2000(amount)) {
            return new BigDecimal("1.15");
        }
        return new BigDecimal("1.3");
    }

    private boolean equalOrBiggerThan1001AndEqualOrLessThan2000(int amount) {
        return amount>=1001 && amount<=2000;
    }

    private boolean equalOrBiggerThan0AndEqualOrLessThan1000(int amount) {
        return amount >= 0 && amount <= 1000;
    }
}
