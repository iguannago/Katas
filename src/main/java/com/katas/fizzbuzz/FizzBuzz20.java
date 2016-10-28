package com.katas.fizzbuzz;

/**
 * Created by davicres on 28/10/2016.
 */
public class FizzBuzz20 {
    public String print(int input) {
        if (input > 100 || input < 1) {
            throw new RuntimeException("input is invalid");
        }
        if (isMultipleOf3(input) && isMultipleOf5(input)) {
            return "FizzBuzz";
        }
        if (isMultipleOf3(input)) {
            return "Fizz";
        }
        if (isMultipleOf5(input)) {
            return "Buzz";
        }
        return String.valueOf(input);
    }

    private boolean isMultipleOf5(int input) {
        return input % 5 == 0;
    }

    private boolean isMultipleOf3(int input) {
        return input % 3 == 0;
    }
}
