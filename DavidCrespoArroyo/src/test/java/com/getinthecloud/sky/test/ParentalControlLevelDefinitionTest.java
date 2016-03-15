package com.getinthecloud.sky.test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by davicres on 01/03/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class ParentalControlLevelDefinitionTest {
    /**
     * U, PG, 12, 15, 18
     */
    @Test
    public void parentalControlLevelDefinitionMatchesRequirementTest() {
        assertTrue(ParentalControlLevelDefinition.LevelU.getLevel() < ParentalControlLevelDefinition.LevelPG.getLevel());
        assertTrue(ParentalControlLevelDefinition.LevelPG.getLevel() < ParentalControlLevelDefinition.Level12.getLevel());
        assertTrue(ParentalControlLevelDefinition.Level12.getLevel() < ParentalControlLevelDefinition.Level15.getLevel());
        assertTrue(ParentalControlLevelDefinition.Level15.getLevel() < ParentalControlLevelDefinition.Level18.getLevel());
    }

    @Test
    @Parameters(method = "getLevels")
    public void getParentalControlLevelDefinitionTest(String level) {
        ParentalControlLevelDefinition actualParentalControl = ParentalControlLevelDefinition.
                getParentalControlLevelDefinition(level);
        switch (level) {
            case "U": assertEquals(ParentalControlLevelDefinition.LevelU, actualParentalControl);break;
            case "PG":assertEquals(ParentalControlLevelDefinition.LevelPG, actualParentalControl);break;
            case "12":assertEquals(ParentalControlLevelDefinition.Level12, actualParentalControl);break;
            case "15":assertEquals(ParentalControlLevelDefinition.Level15, actualParentalControl);break;
            case "18":assertEquals(ParentalControlLevelDefinition.Level18, actualParentalControl);break;
        }
    }

    private static final Object[] getLevels() {
        return new String[][]{
                {"U"}, {"PG"}, {"12"}, {"15"}, {"18"}
        };
    }

}
