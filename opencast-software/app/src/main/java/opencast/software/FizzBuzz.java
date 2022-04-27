package opencast.software;

import java.util.function.Predicate;

public class FizzBuzz {

    public String run(int number) {
        Predicate<Integer> multipleOfThree = n -> n % 3 == 0;
        Predicate<Integer> multipleOfFive = n -> n % 5 == 0;

        if (multipleOfThree.and(multipleOfFive).test(number)) {
            return "FizzBuzz";
        }
        if (multipleOfThree.test(number)) {
            return "Fizz";
        }
        if (multipleOfFive.test(number)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

}
