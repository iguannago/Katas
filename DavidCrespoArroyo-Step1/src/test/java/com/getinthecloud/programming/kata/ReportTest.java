package com.getinthecloud.programming.kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/03/2016.
 */
public class ReportTest {

    private final ArrayList<String> collectionOfFizzBuzzAnIntegers =
            new ArrayList<String>(Arrays.asList("fizz", "buzz", "2", "2", "fizz", "buzz", "fizzbuzz", "fizzbuzz"));
    private final Report report = new Report();

    @Test
    public void whenRecordFizzThenReportGetFizzTest() {
        for (String item: collectionOfFizzBuzzAnIntegers) {
            report.record(item);
        }
        assertEquals(getNumberOfItemFromTheCollection("fizz"), report.getFizz());
    }

    @Test
    public void whenRecordBuzzThenReportGetBuzzTest() {
        for (String item: collectionOfFizzBuzzAnIntegers) {
            report.record(item);
        }
        assertEquals(getNumberOfItemFromTheCollection("buzz"), report.getBuzz());
    }

    @Test
    public void whenRecordAnIntegerThenReportGetAnIntegerTest() {
        for (String item: collectionOfFizzBuzzAnIntegers) {
            report.record(item);
        }
        assertEquals(getNumberOfItemFromTheCollection("2"), report.getAnInteger());
    }

    @Test
    public void whenRecordFizzbuzzThenReportGetFizzbuzzTest() {
        for (String item: collectionOfFizzBuzzAnIntegers) {
            report.record(item);
        }
        assertEquals(getNumberOfItemFromTheCollection("fizzbuzz"), report.getFizzbuzz());
    }


    private int getNumberOfItemFromTheCollection(String item) {
        int count = 0;
        for (String i: collectionOfFizzBuzzAnIntegers) {
            if (i.equals(item)) {
                count++;
            }
        }
        return count;
    }

}
