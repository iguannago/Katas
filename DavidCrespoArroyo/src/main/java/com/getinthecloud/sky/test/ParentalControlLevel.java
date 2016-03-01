package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public enum ParentalControlLevel {
    LevelU("U"),
    LevelNP("NP"),
    Level12("12"),
    Level15("15"),
    Level18("18")
    ; // semicolon needed when fields / methods follow


    private final String levelCode;
    private final int level;

    private ParentalControlLevel(String levelCode) {
        this.levelCode = levelCode;
        switch (levelCode) {
            case "U":
                this.level = 1;
                break;

            case "NP":
                this.level = 2;
                break;

            case "12":
                this.level = 3;
                break;

            case "15":
                this.level = 4;
                break;

            case "18":
                this.level = 5;
                break;

            default:
                this.level = 0;
        }
    }

    public int getLevel() {
        return level;
    }
}
