package com.katas.fizzbuzz;

/**
 * Created by davicres on 21/04/2014.
 */
public class FizzBuzz9 {
    public String evaluate(int i) {
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
        return i % 5 == 0;
    }

    private boolean isMultipleOf3(int i) {
        return i % 3 == 0;
    }
}
