package com.katas.fizzbuzz;

public class FizzBuzz25 {
    public String fizzbuzz(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(number);
    }
}
