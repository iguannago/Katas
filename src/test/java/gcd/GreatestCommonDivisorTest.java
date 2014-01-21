package gcd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by d.crespo@london.net-a-porter.com on 13/01/2014.
 * <p/>
 * <p/>
 * So, this is the algorithm:
 * GCD(a,b)
 * if (b==0) return a
 * else return GCD (b, a mod b)
 */
public class GreatestCommonDivisorTest {

    private static Log logger = LogFactory.getLog(GreatestCommonDivisor.class);

    private GreatestCommonDivisor greatestCommonDivisor;
    private int a = 0;
    private int b = 0;

    @Before
    public void setUp() {
        greatestCommonDivisor = new GreatestCommonDivisor();
        Random random = new Random();
        a = random.nextInt(Integer.MAX_VALUE);
        b = random.nextInt(Integer.MAX_VALUE);
    }

    /*
    Testing gcd(a,0)=a
     */
    @Test
    public void gcdWhenBIsZeroReturnA() {
        logger.debug("Test1...");
        assertEquals("When B is 0 returns  A", a, greatestCommonDivisor.gcd(a, 0));
    }

    /**
     * When some of the parameters are 1 then the gcd is 1.
     */
    @Test
    public void gcd1And1Return1() {
        logger.debug("Test2...");
        assertEquals("When A is 1 and B is 1 Returns 1", 1, greatestCommonDivisor.gcd(1, 1));
    }

    /**
     * When some of the parameters are 1 then the gcd is 1.
     */
    @Test
    public void gcd2And1Return1() {
        logger.debug("Test3...");
        assertEquals("When A is 2 and B is 1 Returns  1", 1, greatestCommonDivisor.gcd(2, 1));
    }

    /**
     * When some of the parameters are 1 then the gcd is 1.
     */
    @Test
    public void gcd1And2Return1() {
        logger.debug("Test4...");
        assertEquals("When A is 1 and B is 2 Returns  1", 1, greatestCommonDivisor.gcd(1, 2));
    }

    /**
     * When some of the parameters are 1 then the gcd is 1.
     */
    @Test
    public void gcdIfAIs1ReturnsB() {
        logger.debug("Test5...");
        assertEquals("When A is 1 Returns 1", 1, greatestCommonDivisor.gcd(1, b));
    }

    /**
     * Testing another couple of values
     */
    @Test
    public void gcd2And2Returns2() {
        logger.debug("Test6...");
        assertEquals("When A is 2 and B is 2 Returns 2", 2, greatestCommonDivisor.gcd(2, 2));
    }

    @Test
    public void gcd3And2Returns1() {
        logger.debug("Test7...");
        assertEquals("When A is 3 and B is 2 Returns 1", 1, greatestCommonDivisor.gcd(3, 2));
    }

    @Test
    public void gcd2And3Returns1() {
        logger.debug("Test8...");
        assertEquals("When A is 2 and B is 3 Returns 1", 1, greatestCommonDivisor.gcd(2, 3));
    }

    @Test
    public void gcd15And5Returns5() {
        logger.debug("Test9...");
        assertEquals("When A is 15 and B is 5 Returns 5", 5, greatestCommonDivisor.gcd(15, 5));
    }

    @Test
    public void gcd54And24Returns6() {
        logger.debug("Test10...");
        assertEquals("When A is 54 and B is 24 Returns 6", 6, greatestCommonDivisor.gcd(54, 24));
    }


}
