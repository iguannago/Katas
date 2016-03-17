package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public final class Report {
    private int fizz;
    private int buzz;
    private int anInteger;
    private int fizzbuzz;

    public void record(String input) {
        if (input.equals("fizz")) {
            fizz++;
        }
        else if (input.equals("buzz")) {
            buzz++;
        }
        else if (input.equals("fizzbuzz")){
            fizzbuzz++;
        }
        else {
            anInteger++;
        }
    }

    public int getFizz() {
        return fizz;
    }

    public int getBuzz() {
        return buzz;
    }

    public int getAnInteger() {
        return anInteger;
    }

    public int getFizzbuzz() {
        return fizzbuzz;
    }

    @Override
    public String toString() {
        return "Report{" +
                "fizz=" + fizz +
                ", buzz=" + buzz +
                ", anInteger=" + anInteger +
                '}';
    }

}
