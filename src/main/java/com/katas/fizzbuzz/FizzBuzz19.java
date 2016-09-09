package com.katas.fizzbuzz;

/**
 * Created by davicres on 09/09/2016.
 */
public class FizzBuzz19 {
    public String print(int number) {
        if (isMultipleOf3(number)) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
