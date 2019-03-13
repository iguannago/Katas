package com.katas.fizzbuzz;

public class FizzBuzz24 {
    public String print(int number) {
        if (3 == number) {
            return "Fizz";
        }
        if (5 == number) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
