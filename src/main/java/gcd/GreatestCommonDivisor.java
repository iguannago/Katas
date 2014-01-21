package gcd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by d.crespo@london.net-a-porter.com on 13/01/2014.
 */
public class GreatestCommonDivisor {

    private static Log logger = LogFactory.getLog(GreatestCommonDivisor.class);

    public int gcd(int a, int b) {
        logger.debug("a: " + a);
        logger.debug("b: " + b);
        if ((b == 0)||(a == 0)) {
            int result = (b == 0) ? a : b;
            logger.debug("fast result: " + result);
            return result;
        }
        if ((a == 1) || (b == 1)) {
            logger.debug("fast result: " + 1);
            return 1;
        }
        return gcd(b, a % b);
    }

}
