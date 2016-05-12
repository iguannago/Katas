import java.util.Arrays;
import java.util.List;

/**
 * Created by davicres on 12/05/2016.
 */
public class ReadNumber {

    private final List<String> cadUpTo19 = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen");
    private final List<String> cadFrom20 = Arrays.asList("twenty", "thirty", "forty");

    public String read(int number) {
        System.out.println("number: " + number);

        String result;

        if (number >= 30) {
            result = getString(number, 30, 1);
            return result;
        }

        if (number >= 20) {
            result = getString(number, 20, 0);
            return result;
        }

        result = cadUpTo19.get(number);
        System.out.println("result: " + result);
        return result;
    }

    private String getString(int number, int range, int index) {
        String result;
        int mod = number % range;
        if (mod == 0) {
            result = cadFrom20.get(index);
        }
        else {
            result =  cadFrom20.get(index) + " " + cadUpTo19.get(number % range);
        }
        System.out.println("result: " + result);
        return result;
    }
}
