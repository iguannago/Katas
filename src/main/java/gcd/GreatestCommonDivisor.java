package gcd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by d.crespo@london.net-a-porter.com on 13/01/2014.
 */
public class GreatestCommonDivisor {

    private static Log logger = LogFactory.getLog(GreatestCommonDivisor.class);

    public int gcd(int a, int b) {
        if (logger.isDebugEnabled()) {
            logger.debug("a: " + a);
            logger.debug("b: " + b);
        }
        if (b == 0)
            return a;
        return 0;
    }
}
