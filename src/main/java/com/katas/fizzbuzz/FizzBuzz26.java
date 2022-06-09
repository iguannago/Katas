package com.katas.fizzbuzz;

import java.util.stream.Stream;

public class FizzBuzz26 {
    public String print(int number) {
        if (number % 3 == 0 && number % 5 == 0) return "FizzBuzz";
        if (number % 3 == 0) return "Fizz";
        if (number % 5 == 0) return "Buzz";
        return String.valueOf(number);
    }

    public static void main(String[] args) {
        FizzBuzz26 fizzBuzz26 = new FizzBuzz26();
        Stream.iterate(1, n -> n + 1)
            .limit(100)
            .forEach(x -> System.out.println(fizzBuzz26.print(x)));
    }
}
