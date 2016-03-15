package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */

public enum ParentalControlLevelDefinition {
    LevelU("U", 1),
    LevelPG("PG", 2),
    Level12("12", 3),
    Level15("15", 4),
    Level18("18", 5);

    private final String levelCode;
    private final int level;

    private ParentalControlLevelDefinition(String levelCode, int level) {
        this.levelCode = levelCode;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public static ParentalControlLevelDefinition getParentalControlLevelDefinition(String level) {
        for (ParentalControlLevelDefinition pcld : ParentalControlLevelDefinition.values()) {
            if (pcld.getLevelCode().equals(level)) {
                return pcld;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ParentalControlLevelDefinition{" +
                "levelCode='" + levelCode + '\'' +
                ", level=" + level +
                '}';
    }
}

