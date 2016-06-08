package com.programmingExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by davicres on 08/06/2016.
 */
public class SumThemAll {

    private static long sum(List<Integer> numbers) {
        long result = 0;
        for (int number : numbers) {
            result = result + number;
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Enter number of elements: ");
        Scanner in = new Scanner(System.in);
        int numberOfElement = in.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numberOfElement; i++) {
            System.out.print("Enter number: ");
            Scanner n = new Scanner(System.in);
            numbers.add(n.nextInt());
        }

        System.out.println(numberOfElement);
        System.out.println(numbers);

        System.out.println("sum: " + sum(numbers));
    }
}
