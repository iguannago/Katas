package com.katas.fizzbuzz;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 14/08/13
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzz {
    public String evaluate(int i) {
        StringBuilder result = new StringBuilder();
        if (isMultipleOf3(i)) {
            result.append("Fizz");
        }
        if (isMultipleOf5(i)) {
            result.append("Buzz");
        }
        return (result.toString().isEmpty())?String.valueOf(i):result.toString();
    }

    private boolean isMultipleOf5(int i) {
        return i % 5 == 0;
    }

    private boolean isMultipleOf3(int i) {
        return i % 3 == 0;
    }
}
