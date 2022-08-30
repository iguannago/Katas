package com.katas.fizzbuzz;

public class FizzBuzz27 {
    public String play(int number) {
        if (isMultipleOf(number, 3)) {
            return "Fizz";
        }
        if (isMultipleOf(number, 5)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf(int number, int x) {
        return number % x == 0;
    }
}
