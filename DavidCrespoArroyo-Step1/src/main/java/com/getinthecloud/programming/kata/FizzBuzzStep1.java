package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public class FizzBuzzStep1 {
    public String printFizzBuzz(int number) {
        if (isMultipleOf3(number)&&isMultipleOf5(number)) {
            return "fizzbuzz";
        }
        if (isMultipleOf5(number)) {
            return "buzz";
        }
        if (isMultipleOf3(number)) {
            return "fizz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
