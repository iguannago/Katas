import java.util.Arrays;
import java.util.List;

/**
 * Created by davicres on 12/05/2016.
 */
public class ReadNumber {
    public String read(int number) {
        System.out.println(number);
        List<String> cad = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty");
        return  cad.get(number);
    }
}
