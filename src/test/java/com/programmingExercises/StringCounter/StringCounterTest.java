package com.programmingExercises.StringCounter;

import com.programmingExercises.CounterString.CounterString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 29/04/2016.
 */
public class StringCounterTest {
    @Test
    public void countLetterAInString(){
        String cad = "aabcabzc";
        System.out.println("cad: " + cad);
        CounterString counterString = new CounterString();
        List<Integer> result = counterString.count(cad);
        System.out.println("result: " + result);
        List<Integer> expected = new ArrayList<>(Arrays.asList(3,2,2,1));
        System.out.printf("expected: " + expected);
        assertEquals(expected, result);
    }
}
