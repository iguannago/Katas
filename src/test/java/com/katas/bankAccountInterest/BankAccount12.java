package com.katas.bankAccountInterest;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class BankAccount12 {

    private static final Map<Function<Integer, Boolean>, BigDecimal> bankInterestRules = new LinkedHashMap();

    static {
        Function<Integer, Boolean> interestIs1_1 = (a) -> a > 0 && a <= 1000;
        bankInterestRules.put(interestIs1_1, new BigDecimal("1.1"));
    }

    public BigDecimal getInterest(int amount) {
        bankInterestRules.keySet().stream()
            .filter(f -> f.apply(amount))
            .findFirst()

        if (interestIs1_1.apply(amount)) {
            return new BigDecimal("1.1");
        }
        throw new IllegalArgumentException("amount is not valid");
    }
}
