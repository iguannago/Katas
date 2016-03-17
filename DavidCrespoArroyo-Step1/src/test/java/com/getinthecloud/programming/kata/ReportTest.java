package com.getinthecloud.programming.kata;

import junitparams.JUnitParamsRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/03/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class ReportTest {

    private final ArrayList<String> collectionOfFizzBuzzAnIntegers =
            new ArrayList<String>(Arrays.asList("fizz", "buzz", "2", "fizz", "buzz"));
    private final Report report = new Report();

    @Test
    public void whenRecordFizzThenReportsNumberOfFizz() {
        for (String item: collectionOfFizzBuzzAnIntegers) {
            report.record(item);
        }
        assertEquals(getNumberOfItemFromTheCollection("fizz"), report.getFizz());
    }

    @Test
    public void whenRecordBuzzThenReportsNumberOfBuzz() {
        for (String item: collectionOfFizzBuzzAnIntegers) {
            report.record(item);
        }
        assertEquals(getNumberOfItemFromTheCollection("buzz"), report.getBuzz());
    }


    private int getNumberOfItemFromTheCollection(String item) {
        return StringUtils.countMatches(collectionOfFizzBuzzAnIntegers.toString(), item);
    }

}
