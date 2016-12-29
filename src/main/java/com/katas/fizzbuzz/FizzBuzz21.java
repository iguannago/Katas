package com.katas.fizzbuzz;

import java.util.Calendar;

/**
 * Created by davicres on 15/11/2016.
 */
public class FizzBuzz21 {

    static {
        Calendar cal = Calendar.getInstance();
        System.out.println("cal: " + cal.getTime());
    }

    public String print(int number) {
        if (number < 1 || number > 100) {
            throw new RuntimeException("Number is invalid");
        }
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

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }

    public static void main(String[] args) {
        FizzBuzz21 fizzBuzz21 = new FizzBuzz21();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz21.print(i));
        }
    }
}
