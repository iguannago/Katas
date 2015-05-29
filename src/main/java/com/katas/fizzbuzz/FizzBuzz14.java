package com.katas.fizzbuzz;

/**
 * Created by davicres on 29/05/2015.
 */
public class FizzBuzz14 {
    public String print(int i) {
        if (i < 1) {
            throw new RuntimeException("Number cannot be less than 1");
        }
        if (i >100) {
            throw new RuntimeException("Number cannot be higher than 100");
        }
        if (isMultipleOf3(i)&&isMultipleOf5(i)) {
            return "FizzBuzz";
        }
        if (isMultipleOf3(i)) {
            return "Fizz";
        }
        if (isMultipleOf5(i)) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

    private boolean isMultipleOf5(int i) {
        return (i % 5) == 0;
    }

    private boolean isMultipleOf3(int i) {
        return (i % 3) == 0;
    }
}
