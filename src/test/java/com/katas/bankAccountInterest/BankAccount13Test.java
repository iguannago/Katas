package com.katas.bankAccountInterest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Exercise: Implement a function to get the right interest given an amount of money.
 * Given an amount in a range of [1-1000] the interest is  1.1%
 * Given an amount in a range of [1001 - 2000] the interest is  1.15%
 * Given an amount in a range of [2001 - 3000] the interest is 1.22%
 * Given an amount > 3000 then the interest is 1.3%
 *
 * Also given that:
 * customer wants to return an exception if the amount is negative
 */
public class BankAccount13Test {

	@ParameterizedTest
	@CsvSource({"1.4", "2", "100", "300", "1000"})
	void givenAmount_Then1_1(String amount) {
		BankAccount13 bankAccount13 = new BankAccount13();
		assertEquals(new BigDecimal("1.1"), bankAccount13.getInterest(new BigDecimal(amount)));
	}

	@ParameterizedTest
	@CsvSource({"1001", "1100", "1999", "2000"})
	void givenAmount_Then1_15(String amount) {
		BankAccount13 bankAccount13 = new BankAccount13();
		assertEquals(new BigDecimal("1.15"), bankAccount13.getInterest(new BigDecimal(amount)));
	}

	@ParameterizedTest
	@CsvSource({"2001", "2100", "2999", "3000"})
	void givenAmount_Then1_22(String amount) {
		BankAccount13 bankAccount13 = new BankAccount13();
		assertEquals(new BigDecimal("1.22"), bankAccount13.getInterest(new BigDecimal(amount)));
	}

	@ParameterizedTest
	@CsvSource({"3001", "3100", "3999", "4000"})
	void givenAmount_Then1_3(String amount) {
		BankAccount13 bankAccount13 = new BankAccount13();
		assertEquals(new BigDecimal("1.3"), bankAccount13.getInterest(new BigDecimal(amount)));
	}

	@Test
	void givenNegativeAmount_ThenThrowException() {
		BankAccount13 bankAccount13 = new BankAccount13();
		assertThrows(IllegalArgumentException.class, () -> bankAccount13.getInterest(new BigDecimal("-1")));
	}
}
