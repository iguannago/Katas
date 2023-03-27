package com.katas.fizzbuzz;

public class FizzBuzz29 {
	public String print(int number) {
		if (multipleOf3(number) && multipleOf5(number)) {
			return "FizzBuzz";
		}
		if (multipleOf3(number)) {
			return "Fizz";
		}
		if (multipleOf5(number)) {
			return "Buzz";
		}
		return String.valueOf(number);
	}

	private static boolean multipleOf5(int number) {
		return number % 5 == 0;
	}

	private static boolean multipleOf3(int number) {
		return number % 3 == 0;
	}

	public static void main(String[] args) {
		FizzBuzz29 fizzBuzz = new FizzBuzz29();
		for (int i = 1; i <= 100; i++) {
			System.out.println(fizzBuzz.print(i));
		}
	}
}
