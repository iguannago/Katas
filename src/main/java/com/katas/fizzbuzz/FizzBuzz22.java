package com.katas.fizzbuzz;

/**
 * Created by davicres on 09/01/2017.
 */
public class FizzBuzz22 {
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
