package com.katas.footballTeam;

/**
 * Created by davicres on 09/01/2017.
 */
public final class FootballTeam1 {
    private final int numberOfGamesWon;

    private FootballTeam1(int numberOfGamesWon) {
        this.numberOfGamesWon = numberOfGamesWon;
    }

    public static FootballTeam1 build(int numberOfGamesWon) {
        return new FootballTeam1(numberOfGamesWon);
    }

    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }
}
