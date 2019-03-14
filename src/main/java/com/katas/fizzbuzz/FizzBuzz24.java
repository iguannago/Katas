package com.katas.fizzbuzz;

public class FizzBuzz24 {
    public String print(int number) {
        if (0 == number) {
            throw new IllegalArgumentException("number cannot be Zero or less than Zero");
        }
        if (isMultipleOf3(number) && isMultipleOf5(number)) {
            return "FizzBuzz";
        }
        if (isMultipleOf3(number)) {
            return "Fizz";
        }
        if (isMultipleOf5(number)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
