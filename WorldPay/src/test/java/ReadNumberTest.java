import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 12/05/2016.
 */
public class ReadNumberTest {

    private final ReadNumber readNumber = new ReadNumber();

    @Test
    public void when0ThenZero() {
        String result = readNumber.read(0);
        assertEquals("zero", result);
    }
    @Test
    public void when1ThenOne() {
        String result = readNumber.read(1);
        assertEquals("one", result);
    }
    @Test
    public void when2ThenTwo() {
        String result = readNumber.read(2);
        assertEquals("two", result);
    }




}
