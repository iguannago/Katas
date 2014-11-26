package com.katas.fizzbuzz;

/**
 * Created by davicres on 26/11/2014.
 */
public class FizzBuzz12 {
    public String print(int i) {
        if (isMultipleOf3(i)&&isMultipleOf5(i)) {
            return "FizzBuzz";
        }
        if (isMultipleOf3(i)) {
            return "Fizz";
        }
        if (isMultipleOf5(i)) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

    private boolean isMultipleOf5(int i) {
        return i%5==0;
    }

    private boolean isMultipleOf3(int i) {
        return i%3==0;
    }

    public static void main(String [] args){
        FizzBuzz12 fizzBuzz12 = new FizzBuzz12();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz12.print(i));
        }
    }

}

