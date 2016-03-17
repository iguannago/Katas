package com.getinthecloud.programming.kata;

import junitparams.JUnitParamsRunner;
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

    @Test
    public void whenRecordFizzThenReportPrintsNumberOfFizz() {
        Report report = new Report();
        ArrayList<String> fizzs = new ArrayList<String>(Arrays.asList("fizz", "fizz", "fizz", "fizz"));
        for (String fizz: fizzs) {
            report.record(fizz);
        }
        assertEquals(fizzs.size(), report.getFizz());
    }

}
