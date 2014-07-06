package com.katas.romanNumerals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Documentation:
 *  http://codingdojo.org/cgi-bin/index.pl?KataRomanNumerals
 *  http://www.calculateme.com/cRomanNumerals/ArabicNumeralsToRoman.htm
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

    @Test
    public void roman11ReturnsXI() {
        Assert.assertEquals("XI", romanNumeral.arabicToRoman(11));
    }

    @Test
    public void roman12ReturnsXII() {
        Assert.assertEquals("XII", romanNumeral.arabicToRoman(12));
    }

    @Test
    public void roman14ReturnsXIV() {
        Assert.assertEquals("XIV", romanNumeral.arabicToRoman(14));
    }

    @Test
    public void roman15ReturnsXV() {
        Assert.assertEquals("XV", romanNumeral.arabicToRoman(15));
    }

    @Test
    public void roman16ReturnsXVI() {
        Assert.assertEquals("XVI", romanNumeral.arabicToRoman(16));
    }

    @Test
    public void roman17ReturnsXVII() {
        Assert.assertEquals("XVII", romanNumeral.arabicToRoman(17));
    }

    @Test
    public void roman18ReturnsXVIII() {
        String actual = romanNumeral.arabicToRoman(18);
        Assert.assertEquals("XVIII", actual);
    }

    @Test
    public void roman19ReturnsXIX() {
        String actual = romanNumeral.arabicToRoman(19);
        Assert.assertEquals("XIX", actual);
    }
    @Test
    public void roman20ReturnsXX() {
        String actual = romanNumeral.arabicToRoman(20);
        Assert.assertEquals("XX", actual);
    }
    @Test
    public void roman23ReturnsXXIII() {
        String actual = romanNumeral.arabicToRoman(23);
        Assert.assertEquals("XXIII", actual);
    }
    @Test
    public void roman24ReturnsXXIV() {
        String actual = romanNumeral.arabicToRoman(24);
        Assert.assertEquals("XXIV", actual);
    }

    @Test
    public void roman25ReturnsXXV() {
        String actual = romanNumeral.arabicToRoman(25);
        Assert.assertEquals("XXV", actual);
    }
    @Test
    public void roman39ReturnsXXXIX() {
        String actual = romanNumeral.arabicToRoman(39);
        Assert.assertEquals("XXXIX", actual);
    }


}
