import java.util.Arrays;
import java.util.List;

/**
 * Created by davicres on 12/05/2016.
 */
public class ReadNumber {
    public String read(int number) {
        List<String> cad = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty");
        if (number > 20) {
            return "twenty " + cad.get(number % 20);
        }
        return  cad.get(number);
    }
}
