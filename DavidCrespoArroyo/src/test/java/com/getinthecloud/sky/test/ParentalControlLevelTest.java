package com.getinthecloud.sky.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by davicres on 01/03/2016.
 */
public class ParentalControlLevelTest {
    @Test
    public void parentalControlLevelTest() {
        Assert.assertTrue(ParentalControlLevel.LevelU.getLevel() < ParentalControlLevel.LevelNP.getLevel());
        Assert.assertTrue(ParentalControlLevel.LevelNP.getLevel() < ParentalControlLevel.Level12.getLevel());
        Assert.assertTrue(ParentalControlLevel.Level12.getLevel() < ParentalControlLevel.Level15.getLevel());
        Assert.assertTrue(ParentalControlLevel.Level15.getLevel() < ParentalControlLevel.Level18.getLevel());
    }
}
