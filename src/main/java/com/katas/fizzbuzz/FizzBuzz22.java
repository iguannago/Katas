package com.katas.fizzbuzz;

/**
 * Created by davicres on 09/01/2017.
 */
public class FizzBuzz22 {
    public String print(int number) {
        handleNumberBoundaries(number);
        if (isMultipleOf3(number) && isMultipleOf5(number)) {
            return "FizzBuzz";
        }
        if (isMultipleOf3(number)) {
            return "Fizz";
        }
        if (isMultipleOf5(number)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private void handleNumberBoundaries(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("number is invalid");
        }
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }

    public static void main(String[] args) {
        FizzBuzz22 fizzBuzz22 = new FizzBuzz22();
        for (int i = 1; i < 101; i++) {
            System.out.println(fizzBuzz22.print(i));
        }
    }
}
