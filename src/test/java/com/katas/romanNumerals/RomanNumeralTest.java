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
        Assert.assertEquals("I", romanNumeral.arabicToRoman(1));
    }

    @Test
    public void roman2ReturnsII() {
        Assert.assertEquals("II", romanNumeral.arabicToRoman(2));
    }

    @Test
    public void roman3ReturnsIII() {
        Assert.assertEquals("III", romanNumeral.arabicToRoman(3));
    }

    @Test
    public void roman4ReturnsIV() {
        Assert.assertEquals("IV", romanNumeral.arabicToRoman(4));
    }

    @Test
    public void roman5ReturnsV() {
        Assert.assertEquals("V", romanNumeral.arabicToRoman(5));
    }

    @Test
    public void roman6ReturnsVI() {
        Assert.assertEquals("VI", romanNumeral.arabicToRoman(6));
    }

    @Test
    public void roman7ReturnsVII() {
        Assert.assertEquals("VII", romanNumeral.arabicToRoman(7));
    }

    @Test
    public void roman8ReturnsVIII() {
        Assert.assertEquals("VIII", romanNumeral.arabicToRoman(8));
    }

    @Test
    public void roman9ReturnsIX() {
        Assert.assertEquals("IX", romanNumeral.arabicToRoman(9));
    }

    @Test
    public void roman10ReturnsX() {
        Assert.assertEquals("X", romanNumeral.arabicToRoman(10));
    }

}
