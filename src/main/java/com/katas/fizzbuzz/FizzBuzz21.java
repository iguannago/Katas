package com.katas.fizzbuzz;

/**
 * Created by davicres on 15/11/2016.
 */
public class FizzBuzz21 {
    public String print(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
