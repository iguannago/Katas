package com.katas.fizzbuzz;

/**
 * Created by davicres on 27/07/2015.
 */
public class FizzBuzz15 {
    public String print(int i) {
        if (i < 1)
            throw new RuntimeException();

        if (i > 100)
            throw new RuntimeException();

        if (isMultipleOf5(i) && isMultipleOf3(i))
            return "FizzBuzz";

        if (isMultipleOf3(i))
            return "Fizz";

        if (isMultipleOf5(i))
            return "Buzz";

        return String.valueOf(i);
    }

    private boolean isMultipleOf5(int i) {
        return i%5==0;
    }

    private boolean isMultipleOf3(int i) {
        return i%3==0;
    }

    public static void main(String[] args) {
        FizzBuzz15 fizzBuzz15 = new FizzBuzz15();
        for (int i = 1; i <= 100; i++) {
            System.out.println("i = " + fizzBuzz15.print(i));
        }
    }

}
