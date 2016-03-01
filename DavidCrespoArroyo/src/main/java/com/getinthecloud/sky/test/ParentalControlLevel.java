package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */

public final class ParentalControlLevel {

    public enum ParentalControlLevelDefinition {
        LevelU("U", 1),
        LevelPG("PG", 2),
        Level12("12", 3),
        Level15("15", 4),
        Level18("18", 5); // semicolon needed when fields / methods follow


        private final String levelCode;
        private final int level;

        private ParentalControlLevelDefinition(String levelCode, int level) {
            this.levelCode = levelCode;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

    }

    public static int getLevelForTheGivenLevelCode(String levelCode) {
        switch (levelCode) {
            case "U":
                return ParentalControlLevelDefinition.LevelU.getLevel();

            case "PG":
                return ParentalControlLevelDefinition.LevelPG.getLevel();

            case "12":
                return ParentalControlLevelDefinition.Level12.getLevel();

            case "15":
                return ParentalControlLevelDefinition.Level15.getLevel();

            case "18":
                return ParentalControlLevelDefinition.Level18.getLevel();

            default:
                throw new IllegalArgumentException();
        }
    }


}

