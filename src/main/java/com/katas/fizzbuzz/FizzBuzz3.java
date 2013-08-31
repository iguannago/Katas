package com.katas.fizzbuzz;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 31/08/13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzz3 {

    public static final String ZERO = "0";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public String evaluate(int i) {
        if (i == 0) {
            return ZERO;
        }
        if (multipleOf3(i) && multipleOf5(i)) {
            return new StringBuilder(FIZZ).append(BUZZ).toString();
        }
        if (multipleOf3(i)) {
            return FIZZ;
        }
        if (multipleOf5(i)) {
            return BUZZ;
        }
        return String.valueOf(i);
    }

    private boolean multipleOf5(int i) {
        return i % 5 == 0;
    }

    private boolean multipleOf3(int i) {
        return i % 3 == 0;
    }
}
