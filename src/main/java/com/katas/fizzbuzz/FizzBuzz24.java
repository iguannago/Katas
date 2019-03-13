package com.katas.fizzbuzz;

public class FizzBuzz24 {
    public String print(int number) {
        if (isMultipleOf3(number)) {
            return "Fizz";
        }
        if (isMultipleOf5(number)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf5(int number) {
        return number%5==0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
