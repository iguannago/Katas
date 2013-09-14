package com.katas.fizzbuzz;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 14/09/13
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzz5 {

    public static final String ZERO = "0";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = "FizzBuzz";

    public String evaluate(int i) {
        if (isZero(i)) {
            return ZERO;
        }
        if (isMultipleOf3(i) && isMultipleOf5(i)) {
            return FIZZ_BUZZ;
        }
        if (isMultipleOf3(i)) {
            return FIZZ;
        }
        if (isMultipleOf5(i)) {
            return BUZZ;
        }
        return String.valueOf(i);
    }

    private boolean isMultipleOf5(int i) {
        return i % 5 == 0;
    }

    private boolean isMultipleOf3(int i) {
        return i % 3 == 0;
    }

    private boolean isZero(int i) {
        return i == 0;
    }
}
