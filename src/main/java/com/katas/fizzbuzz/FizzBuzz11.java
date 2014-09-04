package com.katas.fizzbuzz;

/**
 * Created by davicres on 04/09/2014.
 */
public class FizzBuzz11 {
    public void print1To100() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(print(i));
        }
    }
    public String print(int i) {
        if (multipleOfThree(i)&&multipleOfFive(i)) {
            return "FizzBuzz";
        }
        if (multipleOfThree(i)) {
            return "Fizz";
        }
        if (multipleOfFive(i)) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

    private boolean multipleOfFive(int i) {
        return i % 5 == 0;
    }

    private boolean multipleOfThree(int i) {
        return i % 3 == 0;
    }

    public static void main(String[] args) {
        FizzBuzz11 fizzBuzz11 = new FizzBuzz11();
        fizzBuzz11.print1To100();
    }
}

