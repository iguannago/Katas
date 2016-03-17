package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public final class FizzBuzzStep1 {
    public String printFizzBuzz(int number) {
        if (numberContains3(number)) {
            //TODO: move the hardcoded string to a Enum type
            return "lucky";
        }
        if (isMultipleOf3(number)&&isMultipleOf5(number)) {
            return "fizzbuzz";
        }
        if (isMultipleOf5(number)) {
            return "buzz";
        }
        if (isMultipleOf3(number)) {
            return "fizz";
        }
        return String.valueOf(number);
    }

    private boolean numberContains3(int number) {
        return String.valueOf(number).contains("3");
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }

    public static void main(String[] args) {
        FizzBuzzStep1 fizzBuzzStep1 = new FizzBuzzStep1();
        Report report = new Report();
        for (int i = 1; i <= 20; i++) {
            String fizzbuzz = fizzBuzzStep1.printFizzBuzz(i);
            report.record(fizzbuzz);
            System.out.println(fizzbuzz);
        }
        System.out.println(report.toString());
    }
}
