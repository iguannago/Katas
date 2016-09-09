package com.katas.fizzbuzz;

/**
 * Created by davicres on 09/09/2016.
 */
public class FizzBuzz19 {
    public String print(int number) {
        if (number <= 0) {
            throw new RuntimeException("Number is equal or less than Zero");
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
