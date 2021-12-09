package com.katas.fizzbuzz;

public class FizzBuzz25 {
    public String fizzbuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    public static void main(String[] args) {
        FizzBuzz25 fizzBuzz25 = new FizzBuzz25();

        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz25.fizzbuzz(i));
        }
    }
}
