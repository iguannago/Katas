package com.katas.fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class FizzBuzz28 {
    static Map<Function<Integer, Boolean>, String> rules = new LinkedHashMap<>(); //keep insertion order

    static {
        Function<Integer, Boolean> multipleOf3 = input -> input % 3 == 0;
        Function<Integer, Boolean> multipleOf5 = input -> input % 5 == 0;
        Function<Integer, Boolean> multipleOf3And5 = input -> multipleOf3.apply(input) && multipleOf5.apply(input);

        rules.put(multipleOf3And5, "FizzBuzz"); // this one has to be checked first (insertion order is kept)
        rules.put(multipleOf3, "Fizz");
        rules.put(multipleOf5, "Buzz");
    }

    public String run(int input) {
        return rules.keySet().stream()
            .filter(r -> r.apply(input))
            .map(r -> rules.get(r))
            .findFirst().orElse(String.valueOf(input));
    }
}
