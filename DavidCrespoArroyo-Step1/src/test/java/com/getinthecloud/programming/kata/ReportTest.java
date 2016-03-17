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

    private final ArrayList<String> fizzs = new ArrayList<String>(Arrays.asList("fizz", "buzz", "2", "fizz"));
    private final Report report = new Report();

    @Test
    public void whenRecordFizzThenReportsNumberOfFizz() {
        for (String fizz: fizzs) {
            report.record(fizz);
        }
        assertEquals(StringUtils.countMatches(fizzs.toString(), "fizz"), report.getFizz());
    }

}
