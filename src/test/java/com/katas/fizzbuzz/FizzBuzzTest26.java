package com.katas.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/*

Write a program that prints one line for each number from 1 to 100
For multiples of three print Fizz instead of the number
For the multiples of five print Buzz instead of the number
For numbers which are multiples of both three and five print FizzBuzz instead of the number

 */
public class FizzBuzzTest26 {
    public static Stream<Arguments> scenarioProvider() {
        return Stream.of(
            Arguments.of(1, "1"),
            Arguments.of(2, "2"),
            Arguments.of(3, "Fizz"),
            Arguments.of(4, "4"),
            Arguments.of(5, "Buzz"),
            Arguments.of(6, "Fizz"),
            Arguments.of(7, "7"),
            Arguments.of(9, "Fizz"),
            Arguments.of(10, "Buzz"),
            Arguments.of(15, "FizzBuzz")
        );
    }

    @ParameterizedTest
    @MethodSource("scenarioProvider")
    void whenOneThenReturnsOne(int input, String expected) {
        FizzBuzz26 fizzBuzz26 = new FizzBuzz26();
        String actualResult = fizzBuzz26.print(input);
        Assertions.assertEquals(expected, actualResult);
    }
}
