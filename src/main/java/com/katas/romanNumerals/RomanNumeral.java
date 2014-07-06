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
                if (cont % 10 == 3){
                    roman.replace(roman.length()-2, roman.length(), "V");
                }
                if (cont % 10 == 8){
                    roman.replace(roman.length()-4, roman.length(), "IX");
                }
            } else {
                if (cont % 10 == 4) {
                    roman = roman.replace(roman.length()-2, roman.length(), "V");
                } else if (cont % 10 == 9) {
                    roman = roman.replace(roman.length()-2, roman.length(), "X");
                } else {
                    roman = roman.append("I");
                }
            }
            cont++;
        }
        return roman.toString();
    }
}
