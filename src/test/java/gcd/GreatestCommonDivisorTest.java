package gcd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by d.crespo@london.net-a-porter.com on 13/01/2014.
 *
 *
   So, this is the algorithm:
       GCD(a,b)  // assume a >= b (will be true after 1st iteration anyway)
 	if (b==0) return a
 	else return GCD (b, a mod b)
 */
public class GreatestCommonDivisorTest {

    private GreatestCommonDivisor greatestCommonDivisor;
    private int a;
    private int b;

    @Before
    public void setUp() {
        greatestCommonDivisor = new GreatestCommonDivisor();
        Random random = new Random();
        a = random.nextInt();
        b = random.nextInt();

    }

    /*
    Testing gcd(a,0)=a
     */
    @Test
    public void gcdWhenBIsZeroReturnA() {
        Assert.assertEquals("When B is 0 the result is A", a, greatestCommonDivisor.gcd(a, 0));
    }




}
