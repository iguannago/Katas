package com.katas.fizzbuzz;

public class FizzBuzzApp {
    public static void main(String[] args) {
        FizzBuzz24 fizzBuzz24 = new FizzBuzz24();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz24.print(i));
        }

    }
}
