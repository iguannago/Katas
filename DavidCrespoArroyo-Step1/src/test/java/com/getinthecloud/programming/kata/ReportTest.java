package com.getinthecloud.programming.kata;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/03/2016.
 */
public class ReportTest {

    private final ArrayList<String> collectionOfFizzBuzzAnIntegers =
            new ArrayList<String>(Arrays.asList("fizz", "buzz", "2", "2", "fizz", "buzz"));
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


    private int getNumberOfItemFromTheCollection(String item) {
        return StringUtils.countMatches(collectionOfFizzBuzzAnIntegers.toString(), item);
    }

}
