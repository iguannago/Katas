package com.katas.fizzbuzz;

/**
 * Created by davicres on 03/09/2015.
 */
public class FizzBuzz16 {
    public String print(int i) {
        if ((i < 1) || (i > 100))
            throw new RuntimeException();
        if (multipleOf3(i) && multipleOf5(i))
            return "FizzBuzz";
        if (multipleOf3(i))
            return "Fizz";
        if (multipleOf5(i))
            return "Buzz";
        return String.valueOf(i);
    }

    private boolean multipleOf5(int i) {
        return i % 5 == 0;
    }

    private boolean multipleOf3(int i) {
        return i % 3 == 0;
    }

    public static void main(String[] args) {
        FizzBuzz16 fizzBuzz16 = new FizzBuzz16();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz16.print(i));
        }
    }

}
