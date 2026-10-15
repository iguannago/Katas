# FizzBuzz kata

Implement the method `String convert(int number)` in `FizzBuzz` using test-driven development.

## Requirements

For a positive integer:

- Return `"FizzBuzz"` if the number is divisible by both 3 and 5.
- Return `"Fizz"` if it is divisible by 3 only.
- Return `"Buzz"` if it is divisible by 5 only.
- Otherwise, return the number as a string.

For this practice exercise, zero and negative numbers must throw `IllegalArgumentException`.

The method returns a single result. Printing a sequence or building a command-line application is outside the exercise.

## Examples

| Input | Expected result |
| --- | --- |
| 1 | `"1"` |
| 2 | `"2"` |
| 3 | `"Fizz"` |
| 6 | `"Fizz"` |
| 5 | `"Buzz"` |
| 10 | `"Buzz"` |
| 15 | `"FizzBuzz"` |
| 30 | `"FizzBuzz"` |
| 0 | `IllegalArgumentException` |
| -1 | `IllegalArgumentException` |

## Approach

1. Remove the class-level `@Disabled` annotation from `FizzBuzzTest`.
2. Run the starter test and observe its failure.
3. Write the smallest implementation that makes it pass.
4. Add one new test at a time until all requirements are covered.
5. Refactor while keeping the tests green. Keep the design proportionate to the problem.

From the `createfuture-java25` project directory, run:

```sh
mvn -Dtest=FizzBuzzTest test
```

Aim for 20 minutes. Explain your test choices, edge cases and design decisions aloud as you work.
