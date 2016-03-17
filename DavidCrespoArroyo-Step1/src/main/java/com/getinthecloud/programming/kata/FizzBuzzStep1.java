package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public class FizzBuzzStep1 {
    public String printFizzBuzz(int number) {
        if (number % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(number);
    }
}
