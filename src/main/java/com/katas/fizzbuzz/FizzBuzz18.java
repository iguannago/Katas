package com.katas.fizzbuzz;

/**
 * Created by davicres on 30/06/2016.
 */
public final class FizzBuzz18 {
    public String print(int i) {
        if (i % 3 == 0)
            return "Fizz";
        if (i == 5)
            return "Buzz";
        return String.valueOf(i);
    }
}
