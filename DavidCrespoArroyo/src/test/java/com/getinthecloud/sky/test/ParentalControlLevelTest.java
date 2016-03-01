package com.getinthecloud.sky.test;

import com.getinthecloud.sky.test.ParentalControlLevel.ParentalControlLevelDefinition;
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
public class ParentalControlLevelTest {
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
    @Parameters(method = "getParentalControlLevel")
    public void parentalControlLevelMethodGetLevelForTheGivenLevelCodeTest(String parentalControlLevel) {
        switch (parentalControlLevel) {
            case "U":
                assertEquals(ParentalControlLevelDefinition.LevelU.getLevel(),
                        ParentalControlLevel.getLevelForTheGivenLevelCode(parentalControlLevel));
                break;

            case "NP":
                assertEquals(ParentalControlLevelDefinition.LevelPG.getLevel(),
                        ParentalControlLevel.getLevelForTheGivenLevelCode(parentalControlLevel));
                break;

            case "12":
                assertEquals(ParentalControlLevelDefinition.Level12.getLevel(),
                        ParentalControlLevel.getLevelForTheGivenLevelCode(parentalControlLevel));
                break;

            case "15":
                assertEquals(ParentalControlLevelDefinition.Level15.getLevel(),
                        ParentalControlLevel.getLevelForTheGivenLevelCode(parentalControlLevel));
                break;

            case "18":
                assertEquals(ParentalControlLevelDefinition.Level18.getLevel(),
                        ParentalControlLevel.getLevelForTheGivenLevelCode(parentalControlLevel));
                break;
        }
    }

    private static final Object[] getParentalControlLevel() {
        return new String[][]{
                {"U"}, {"PG"}, {"12"}, {"15"}, {"18"}
        };
    }

}
