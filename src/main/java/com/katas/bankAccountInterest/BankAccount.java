package com.katas.bankAccountInterest;

import java.math.BigDecimal;

public class BankAccount {

    public static final BigDecimal INTEREST_1_1 = new BigDecimal("1.1");
    public static final BigDecimal INTEREST_1_15 = new BigDecimal("1.15");
    public static final BigDecimal INTEREST_1_22 = new BigDecimal("1.22");
    public static final BigDecimal INTEREST_1_3 = new BigDecimal("1.3");

    public static final BigDecimal LOWEST_BOUNDARY_FOR_1_15_INTEREST = new BigDecimal("1001");
    public static final BigDecimal GREATEST_BOUNDARY_FOR_1_15_INTEREST = new BigDecimal("2000");

    public static final BigDecimal LOWEST_BOUNDARY_FOR_1_22_INTEREST = new BigDecimal("2001");
    public static final BigDecimal GREATEST_BOUNDARY_FOR_1_22_INTEREST = new BigDecimal("3000");

    public BigDecimal getInterest(BigDecimal amount) {
        if (amountIsNegative(amount)) {
            throw new RuntimeException("amount is negative: " + amount);
        }
        if (matchTo1_15Interest(amount)) return INTEREST_1_15;
        if (matchTo1_22Interest(amount)) return INTEREST_1_22;
        if (amountGreaterThanGreatestBoundaryFor1_22(amount)) return INTEREST_1_3;
        return INTEREST_1_1;
    }

    private boolean amountGreaterThanGreatestBoundaryFor1_22(BigDecimal amount) {
        return amount.compareTo(GREATEST_BOUNDARY_FOR_1_22_INTEREST) == 1;
    }

    private boolean matchTo1_22Interest(BigDecimal amount) {
        if (amountIsEqualToLowestBoundaryFor1_22(amount)) {
            return true;
        }
        if (amountIsEqualToGreatestBoundaryFor1_22(amount)) {
            return true;
        }
        if (amountIsGreaterThanLowestBoundaryFor1_22(amount) &&
                amountIsLowerThanGreatestBoundaryFor1_22(amount)) {
            return true;
        }
        return false;
    }

    private boolean amountIsLowerThanGreatestBoundaryFor1_22(BigDecimal amount) {
        return amount.compareTo(GREATEST_BOUNDARY_FOR_1_22_INTEREST) == -1;
    }

    private boolean amountIsGreaterThanLowestBoundaryFor1_22(BigDecimal amount) {
        return amount.compareTo(LOWEST_BOUNDARY_FOR_1_22_INTEREST) == 1;
    }

    private boolean amountIsEqualToGreatestBoundaryFor1_22(BigDecimal amount) {
        return amount.compareTo(GREATEST_BOUNDARY_FOR_1_22_INTEREST) == 0;
    }

    private boolean amountIsEqualToLowestBoundaryFor1_22(BigDecimal amount) {
        return amount.compareTo(LOWEST_BOUNDARY_FOR_1_22_INTEREST) == 0;
    }

    private boolean matchTo1_15Interest(BigDecimal amount) {
        if (amountIsEqualToLowestBoundaryFor1_15(amount)) {
            return true;
        }
        if (amountIsEqualToGreatestBoundaryFor1_15(amount)) {
            return true;
        }
        if (amountGreaterThanLowestBoundaryFor1_15(amount) &&
                amountLessThanGreatestBoundaryFor1_15(amount)) {
            return true;
        }
        return false;
    }

    private boolean amountIsNegative(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) == -1;
    }

    private boolean amountIsEqualToGreatestBoundaryFor1_15(BigDecimal amount) {
        return amount.compareTo(GREATEST_BOUNDARY_FOR_1_15_INTEREST) == 0;
    }

    private boolean amountIsEqualToLowestBoundaryFor1_15(BigDecimal amount) {
        return amount.compareTo(LOWEST_BOUNDARY_FOR_1_15_INTEREST) == 0;
    }

    private boolean amountLessThanGreatestBoundaryFor1_15(BigDecimal amount) {
        return amount.compareTo(GREATEST_BOUNDARY_FOR_1_15_INTEREST) == -1;
    }

    private boolean amountGreaterThanLowestBoundaryFor1_15(BigDecimal amount) {
        return amount.compareTo(LOWEST_BOUNDARY_FOR_1_15_INTEREST) == 1;
    }
}
