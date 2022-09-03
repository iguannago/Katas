package com.katas.fizzbuzz;

public class FizzBuzzApp {
    public static void main(String[] args) {
        FizzBuzz28 fizzBuzz28 = new FizzBuzz28();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz28.run(i));
        }

    }
}
