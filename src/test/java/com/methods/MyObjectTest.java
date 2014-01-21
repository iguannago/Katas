package com.methods;

import methods.MyObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * Created by dcrespo on 19/01/14.
 */
public class MyObjectTest {

    private static Log logger = LogFactory.getLog(MyObjectTest.class);

    @Test
    public void  myTest() {
        String test = "test";
        MyObject myObject = new MyObject();
        logger.debug("Before method...");
        logger.debug("myTest:" + test);
        logger.debug("myObject:" + myObject.getCad());
        changeTest(test, myObject);
        logger.debug("After method...");
        logger.debug("myTest:" + test);
        logger.debug("myObject:" + myObject.getCad());
    }

    private void changeTest(String test, MyObject mO) {
        test = "testChanged";
        mO.setCad("cadChanged");
    }

}
