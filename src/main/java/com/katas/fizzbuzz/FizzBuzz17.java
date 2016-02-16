package com.katas.fizzbuzz;

/**
 * Created by davicres on 16/02/2016.
 */
public final class FizzBuzz17 {
    public String printNumber(int i) {
        if ((i < 1) || (i > 100))
            throw new IllegalArgumentException();
        if (isMultipleOf3(i) && isMultipleOf5(i))
            return "FizzBuzz";
        if (isMultipleOf3(i))
            return "Fizz";
        if (isMultipleOf5(i))
            return "Buzz";
        return String.valueOf(i);
    }

    private boolean isMultipleOf5(int i) {
        return i % 5 == 0;
    }

    private boolean isMultipleOf3(int i) {
        return i % 3 == 0;
    }

    public static void main(String[] args) {
        FizzBuzz17 fizzBuzz17 = new FizzBuzz17();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz17.printNumber(i));
        }
    }
}
