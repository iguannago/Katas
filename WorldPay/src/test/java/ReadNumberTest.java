import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 12/05/2016.
 */
public class ReadNumberTest {

    private final ReadNumber readNumber = new ReadNumber();

    @Test
    public void when0ThenZero() {
        assertEquals("zero", readNumber.read(0));
    }
    @Test
    public void when1ThenOne() {
        assertEquals("one", readNumber.read(1));
    }
    @Test
    public void when2ThenTwo() {
        assertEquals("two", readNumber.read(2));
    }
    @Test
    public void when3ThenThree() {
        assertEquals("three", readNumber.read(3));
    }
    @Test
    public void when4ThenFour() {
        assertEquals("four", readNumber.read(4));
    }
    @Test
    public void when5ThenFive() {
        assertEquals("five", readNumber.read(5));
    }
    @Test
    public void when6ThenSix() {
        assertEquals("six", readNumber.read(6));
    }
    @Test
    public void when7ThenSeven() {
        assertEquals("seven", readNumber.read(7));
    }
    @Test
    public void when8ThenEight() {
        assertEquals("eight", readNumber.read(8));
    }
    @Test
    public void when9ThenNine() {
        assertEquals("nine", readNumber.read(9));
    }




}
