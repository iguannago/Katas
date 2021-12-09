package com.katas.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
Write a program that prints one line for each number from 1 to 100
For multiples of three print Fizz instead of the number
For the multiples of five print Buzz instead of the number
For numbers which are multiples of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzzJupiter25 {

    private final FizzBuzz25 fizzBuzz25 = new FizzBuzz25();

    @ParameterizedTest
    @CsvSource({
        "1,1",
        "2,2",
        "3,Fizz",
        "4,4",
        "5,Buzz",
        "6,Fizz",
        "10,Buzz",
        "15,FizzBuzz",
        "30,FizzBuzz",
        "41,41"
    })
    void when_number_then_Fizz_Buzz_FizzBuzz_or_number(int number, String expected) {
        Assertions.assertEquals(expected, fizzBuzz25.fizzbuzz(number));
    }

}
