package com.katas.bankAccountInterest;

import java.math.BigDecimal;

/**
 * Created by davicres on 23/09/2014.
 */
public class BankAccount2 {

    public static final String ONE_POINT_FIFTEEN = "1.15";
    public static final String ONE_POINT_ONE = "1.1";
    public static final String ONE_POINT_TWENTY_TWO = "1.22";
    public static final String ONE_POINT_THREE = "1.3";

    public String getRightInterest(BigDecimal amount) {
        if (isLessThanZero(amount)) {
            throw new RuntimeException("Negative amount is not permitted");
        }
        if (isGreaterThanUpperLimit(amount, "3000")) {
            return ONE_POINT_THREE;
        }
        if (isGreaterThanUpperLimit(amount, "2000")) {
            return ONE_POINT_TWENTY_TWO;
        }
        if (isGreaterThanUpperLimit(amount, "1000")) {
            return ONE_POINT_FIFTEEN;
        }
        return ONE_POINT_ONE;
    }

    private boolean isLessThanZero(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) == -1;
    }

    private boolean isGreaterThanUpperLimit(BigDecimal amount, String upperLimit) {
        return amount.compareTo(new BigDecimal(upperLimit)) == 1;
    }

}
