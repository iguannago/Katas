package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public class FizzBuzzStep1 {
    public String printFizzBuzz(int number) {
        if (number == 5) {
            return "buzz";
        }
        if (isMultipleOf3(number)) {
            return "fizz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
