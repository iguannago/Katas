package com.katas.romanNumerals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Documentation: http://codingdojo.org/cgi-bin/index.pl?KataRomanNumerals
 * Created by davicres on 26/05/2014.
 */
public class RomanNumeralTest {

    private RomanNumeral romanNumeral;

    @Before
    public void setUp() throws Exception {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void roman1ReturnsI() {
        Assert.assertEquals("I", romanNumeral.romanToArabic(1));
    }

    @Test
    public void roman2ReturnsII() {
        Assert.assertEquals("II", romanNumeral.romanToArabic(2));
    }

    @Test
    public void roman3ReturnsIII() {
        Assert.assertEquals("III", romanNumeral.romanToArabic(3));
    }

}
