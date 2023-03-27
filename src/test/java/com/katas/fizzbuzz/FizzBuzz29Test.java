package com.katas.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzz29Test {

	@ParameterizedTest
	@CsvSource({"1,1", "2,2", "3,Fizz", "4,4", "5,Buzz", "6,Fizz", "7,7", "8,8", "9,Fizz", "10,Buzz", "11,11", "12,Fizz", "13,13", "14,14", "15,FizzBuzz"})
	void given_number_When_fizzBuzz_Then_print_expected(int number, String expected) {
		FizzBuzz29 fizzBuzz = new FizzBuzz29();
		Assertions.assertEquals(expected, fizzBuzz.print(number));
	}

}
