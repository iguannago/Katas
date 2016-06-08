package com.katas.staircase;

/**
 * Created by davicres on 08/06/2016.
 */
public class StairCase {
    public void print(int number) {
        printRecursively(number, number);
    }

    private void printRecursively(int number, int count) {
        if (count > 0) {
            count = count - 1;
            for (int i = 0; i < count ; i++) {
                System.out.print(" ");
            }
            for (int i = count; i < number ; i++) {
                System.out.print("#");
            }

            System.out.println();
            printRecursively(number, count);
        }
    }
}
