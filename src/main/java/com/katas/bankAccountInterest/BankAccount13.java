package com.katas.bankAccountInterest;

import java.math.BigDecimal;

public class BankAccount13 {
	public BigDecimal getInterest(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		}
		if (amount.compareTo(new BigDecimal("3000")) > 0) {
			return new BigDecimal("1.3");
		}
		if (amount.compareTo(new BigDecimal("2000")) > 0) {
			return new BigDecimal("1.22");
		}
		if (amount.compareTo(new BigDecimal("1000")) > 0) {
			return new BigDecimal("1.15");
		}
		return new BigDecimal("1.1");
	}
}
