package com.katas.fizzbuzz;

/**
 * Created by davicres on 15/11/2016.
 */
public class FizzBuzz21 {
    public String print(int number) {
        if (number < 1) {
            throw new RuntimeException();
        }
        if (isMultipleOf3(number)&&isMultipleOf5(number)) {
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
