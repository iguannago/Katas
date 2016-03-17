package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public final class Report {
    private int fizz;

    public void record(String input) {
        if (input.equals("fizz")) {
            fizz++;
        }
    }

    public int getFizz() {
        return fizz;
    }
}
