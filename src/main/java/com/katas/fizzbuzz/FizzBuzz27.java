package com.katas.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzz27 {
    public String play(int number) {
        if (isMultipleOf(number, 3) && isMultipleOf(number, 5)) {
            return "FizzBuzz";
        }
        if (isMultipleOf(number, 3)) {
            return "Fizz";
        }
        if (isMultipleOf(number, 5)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOf(int number, int x) {
        return number % x == 0;
    }

    public static void main(String[] args) {
        FizzBuzz27 fizzBuzz27 = new FizzBuzz27();
        IntStream.range(1, 101)
            .forEach(index -> System.out.println(fizzBuzz27.play(index)));
    }
}
