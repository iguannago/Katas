package com.katas.romanNumerals;

/**
 * Created by davicres on 26/05/2014.
 */
public class RomanNumeral {
    public String arabicToRoman(int number) {
        int cont = 0;
        StringBuffer roman = new StringBuffer();
        while (cont < number) {
            if (roman.toString().contains("III")) {
                if (cont == 3) {
                    roman.replace(0, roman.length(), "IV");
                }
                if (cont == 8) {
                    roman.replace(0, roman.length(), "IX");
                }
            } else {
                if (cont == 4) {
                    roman = roman.replace(0, roman.length(), "V");
                } else if (cont == 9) {
                    roman = roman.replace(0, roman.length(), "X");
                } else {
                    roman = roman.append("I");
                }
            }
            cont++;
        }
        return roman.toString();
    }
}
