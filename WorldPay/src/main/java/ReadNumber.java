import java.util.Arrays;
import java.util.List;

/**
 * Created by davicres on 12/05/2016.
 */
public class ReadNumber {

    public String read(int number) {
        System.out.println("number: " + number);
        List<String> cad = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen");
        String result = "";

        if (number >= 30) {
            int mod = number % 30;
            if (mod == 0) {
                result = "thirty";
            }
            else {
                result =  "thirty " + cad.get(number % 30);
            }
            System.out.println("result: " + result);
            return result;
        }

        if (number >= 20) {
            int mod = number % 20;
            if (mod == 0) {
                result = "twenty";
            }
            else {
                result = "twenty " + cad.get(number % 20);
            }
            System.out.println("result: " + result);
            return result;
        }

        result = cad.get(number);
        System.out.println("result: " + result);
        return result;
    }
}
