package com.katas.fizzbuzz;

/**
 * Created by dcrespo on 24/02/14.
 */
public class FizzBuzz8 {
    public String play(int i) {
        if (multipleOf3(i) && multipleOf5(i)) {
            return "FizzBuzz";
        }
        if (multipleOf3(i)) {
            return "Fizz";
        }
        if (multipleOf5(i)) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

    private boolean multipleOf5(int i) {
        return i % 5 == 0;
    }

    private boolean multipleOf3(int i) {
        return i % 3 == 0;
    }
}
