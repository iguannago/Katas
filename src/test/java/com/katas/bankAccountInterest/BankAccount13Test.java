package com.katas.bankAccountInterest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Exercise: Implement a function to get the right interest given an amount of money.
 * Given an amount in a range of [1-1000] the interest is  1.1%
 * Given an amount in a range of [1001 - 2000] the interest is  1.15%
 * Given an amount in a range of [2001 - 3000] the interest is 1.22%
 * Given an amount > 3000 then the interest is 1.3%
 *
 * Also given that:
 * customer wants for the amount to be a BigDecimal
 * customer wants to return an exception if the amount is negative
 */
public class BankAccount13Test {

	@ParameterizedTest
	@CsvSource({"1.4", "2", "100", "300", "1000"})
	void givenAmount_Then1_1(String amount) {
		BankAccount13 bankAccount13 = new BankAccount13();
		assertEquals(new BigDecimal("1.1"), bankAccount13.getInterest(new BigDecimal(amount)));
	}

	@Test
	void givenAmount_Then1_15() {

	}
}
