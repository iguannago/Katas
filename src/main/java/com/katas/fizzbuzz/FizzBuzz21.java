package com.katas.fizzbuzz;

/**
 * Created by davicres on 15/11/2016.
 */
public class FizzBuzz21 {
    public String print(int number) {
        if (isMultipleOf3(number)) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
