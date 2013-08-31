package com.katas.fizzbuzz;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 26/08/13
 * Time: 01:12
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzz2 {

    public static final String ZERO = "0";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String evaluate(int i) {
        if (isZero(i))
            return ZERO;
        if (isMultipleOf3(i) && isMultipleOf5(i))
            return FIZZBUZZ;
        if (isMultipleOf3(i)) {
            return FIZZ;
        }
        if (isMultipleOf5(i)) {
            return BUZZ;
        }
        return String.valueOf(i);
    }

    private boolean isZero(int i) {
        return i == 0;
    }

    private boolean isMultipleOf5(int i) {
        return isZero(i % 5);
    }

    private boolean isMultipleOf3(int i) {
        return isZero(i % 3);
    }
}
