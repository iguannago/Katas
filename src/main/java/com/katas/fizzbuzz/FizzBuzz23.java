package com.katas.fizzbuzz;

/**
 * Created by davicres on 27/05/2017.
 */
public class FizzBuzz23 {
    public String print(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number is lower than 1");
        }
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

    private boolean multipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean multipleOf3(int number) {
        return number % 3 == 0;
    }
}
