package com.katas.fizzbuzz;

/**
 * Created by davicres on 30/06/2016.
 */
public final class FizzBuzz18 {
    public String print(int i) {
        if (isMultipleOf3(i))
            return "Fizz";
        if (isMultipleOf5(i))
            return "Buzz";
        return String.valueOf(i);
    }

    private boolean isMultipleOf5(int i) {
        return i % 5 == 0;
    }

    private boolean isMultipleOf3(int i) {
        return i % 3 == 0;
    }
}
