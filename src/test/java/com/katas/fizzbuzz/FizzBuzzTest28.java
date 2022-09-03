package com.katas.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzTest28 {

    @ParameterizedTest
    @CsvSource(value = {
        "1,1",
        "2,2",
        "3,Fizz",
        "4,4",
        "5,Buzz",
        "15,FizzBuzz"
    })
    void when1Then1(int input, String expected) {
        FizzBuzz28 fizzBuzz28 = new FizzBuzz28();
        Assertions.assertEquals(expected, fizzBuzz28.run(input));
    }
}
