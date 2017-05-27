package com.katas.fizzbuzz;

/**
 * Created by davicres on 27/05/2017.
 */
public class FizzBuzz23 {
    public String print(int number) {
        if (number == 3) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
