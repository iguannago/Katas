package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public final class Report {
    private int fizz;
    private int buzz;

    public void record(String input) {
        if (input.equals("fizz")) {
            fizz++;
        }
        if (input.equals("buzz")) {
            buzz++;
        }
    }

    public int getFizz() {
        return fizz;
    }

    public int getBuzz() {
        return buzz;
    }
}
