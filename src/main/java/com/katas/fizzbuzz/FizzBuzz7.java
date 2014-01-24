package com.katas.fizzbuzz;

/**
 * Created by dcrespo on 19/01/14.
 */
public class FizzBuzz7 {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public String play(int number) {
        if (isMultipleOfFive(number)&&isMultipleOfThree(number)) {
            return new StringBuffer(FIZZ).append(BUZZ).toString();
        }
        if (isMultipleOfThree(number)) {
            return FIZZ;
        }
        if (isMultipleOfFive(number)) {
            return BUZZ;
        }
        return String.valueOf(number);
    }

    private boolean isMultipleOfFive(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOfThree(int number) {
        return number % 3 == 0;
    }
}
