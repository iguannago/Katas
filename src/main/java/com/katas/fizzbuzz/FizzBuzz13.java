package com.katas.fizzbuzz;

/**
 * Created by davicres on 27/04/2015.
 */
public class FizzBuzz13 {
    public String print(int num) {
        if (isMultipleOf3(num)&&isMultipleOf5(num)) {
            return "FizzBuzz";
        }
        if (isMultipleOf3(num)) {
            return "Fizz";
        }
        if (isMultipleOf5(num)) {
            return "Buzz";
        }
        return String.valueOf(num);
    }

    public void listFrom1To100() {
        for (int i = 1; i < 101; i++) {
            System.out.print(print(i));
        }
    }

    private boolean isMultipleOf5(int num) {
        return num%5==0;
    }

    private boolean isMultipleOf3(int num) {
        return num%3==0;
    }

}
