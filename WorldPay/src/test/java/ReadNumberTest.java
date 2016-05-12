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
    @Test
    public void when10ThenTen() {
        assertEquals("ten", readNumber.read(10));
    }
    @Test
    public void when11ThenEleven() {
        assertEquals("eleven", readNumber.read(11));
    }
    @Test
    public void when12ThenTwelve() {
        assertEquals("twelve", readNumber.read(12));
    }
    @Test
    public void when13ThenThirteen() {
        assertEquals("thirteen", readNumber.read(13));
    }
    @Test
    public void when14ThenFourteen() {
        assertEquals("fourteen", readNumber.read(14));
    }
    @Test
    public void when15ThenFifteen() {
        assertEquals("fifteen", readNumber.read(15));
    }
    @Test
    public void when16ThenSixteen() {
        assertEquals("sixteen", readNumber.read(16));
    }
    @Test
    public void when17ThenSeventeen() {
        assertEquals("seventeen", readNumber.read(17));
    }
    @Test
    public void when18ThenEighteen() {
        assertEquals("eighteen", readNumber.read(18));
    }
    @Test
    public void when19ThenNineteen() {
        assertEquals("nineteen", readNumber.read(19));
    }
    @Test
    public void when20ThenTwenty() {
        assertEquals("twenty", readNumber.read(20));
    }
    @Test
    public void when21ThenTwentyOne() {
        assertEquals("twenty one", readNumber.read(21));
    }
    @Test
    public void when22ThenTwentyTwo() {
        assertEquals("twenty two", readNumber.read(22));
    }
    @Test
    public void when29ThenTwentyNine() {
        assertEquals("twenty nine", readNumber.read(29));
    }
    @Test
    public void when30ThenThirty() {
        assertEquals("thirty", readNumber.read(30));
    }
    @Test
    public void when31ThenThirtyOne() {
        assertEquals("thirty one", readNumber.read(31));
    }





}
