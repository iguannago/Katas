package com.programmingExercises.CounterString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by davicres on 29/04/2016.
 */
public class CounterString {
    public List<Integer> count(String cad) {
        List<Integer> result = new ArrayList<>();
        Set<Character> uniqueChars = getUniqueCharsFromString(cad);
        for (char c: uniqueChars){
            result.add(countGivenCharInCad(cad, c));
        }
        return result;
    }

    private Set<Character> getUniqueCharsFromString(String cad) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < cad.length(); i++) {
            chars.add(cad.charAt(i));
        }
        return chars;
    }

    private int countGivenCharInCad(String cad, char c) {
        int counter = 0;
        for (int i = 0; i < cad.length(); i++) {
            if (cad.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }
}
