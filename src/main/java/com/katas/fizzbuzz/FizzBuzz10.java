package com.katas.fizzbuzz;

/**
 * Created by davicres on 25/06/2014.
 */
public class FizzBuzz10 {
    public String evaluate(int i) {
        if (i == 0) {
            throw new RuntimeException("Zero is not allowed");
        }
        if (isMultipleOf3(i) && isMultipleOf5(i)) {
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
        return i % 5 == 0;
    }

    private boolean isMultipleOf3(int i) {
        return i % 3 == 0;
    }
}
