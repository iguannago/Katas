package com.getinthecloud.katas.fizzbuzz;

public final class FizzBuzz {

    public String convert(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(number);
    }
}
