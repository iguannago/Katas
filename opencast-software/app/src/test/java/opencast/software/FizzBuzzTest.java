package opencast.software;

/**
 * Write a program that prints one line for each number from 1 to 100
For multiples of three print Fizz instead of the number
For the multiples of five print Buzz instead of the number
For numbers which are multiples of both three and five print FizzBuzz instead of the number
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, Fizz",
            "5, Buzz",
            "6, Fizz",
            "7, 7",
            "15, FizzBuzz"
    })
    public void whenOneThenOne(int number, String expected) {
        Assertions.assertEquals(expected, fizzBuzz.run(number));
    }

}
