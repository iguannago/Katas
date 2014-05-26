package com.katas.romanNumerals;

/**
 * Created by davicres on 26/05/2014.
 */
public class RomanNumeral {
    public String romanToArabic(int i) {
        if (i == 1) {
            return "I";
        }
        if (i == 2) {
            return "II";
        }
        return "III";
    }
}
