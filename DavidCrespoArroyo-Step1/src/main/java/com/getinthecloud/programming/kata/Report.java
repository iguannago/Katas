package com.getinthecloud.programming.kata;

/**
 * Created by davicres on 17/03/2016.
 */
public final class Report {
    private int fizz = 0;
    private int buzz = 0;
    private int integer = 0;
    private int fizzbuzz = 0;
    private int lucky = 0;

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
        else if (input.equals("lucky")) {
            lucky++;
        }
        else {
            integer++;
        }
    }

    public int getFizz() {
        return fizz;
    }

    public int getBuzz() {
        return buzz;
    }

    public int getInteger() {
        return integer;
    }

    public int getFizzbuzz() {
        return fizzbuzz;
    }

    public int getLucky() {
        return lucky;
    }

    @Override
    public String toString() {
        return "Report{" +
                "fizz=" + fizz +
                ", buzz=" + buzz +
                ", integer=" + integer +
                ", fizzbuzz=" + fizzbuzz +
                ", lucky=" + lucky +
                '}';
    }
}
