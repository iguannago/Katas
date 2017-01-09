package com.katas.footballTeam;

/**
 * Created by davicres on 09/01/2017.
 */
public final class FootballTeam1 implements Comparable {
    private final int numberOfGamesWon;

    private FootballTeam1(int numberOfGamesWon) {
        this.numberOfGamesWon = numberOfGamesWon;
    }

    public static FootballTeam1 build(int numberOfGamesWon) {
        return new FootballTeam1(numberOfGamesWon);
    }

    int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    @Override
    public int compareTo(Object o) {
        FootballTeam1 footballTeam1 = (FootballTeam1) o;
        if (this.getNumberOfGamesWon() > footballTeam1.getNumberOfGamesWon()) {
            return 1;
        } else if (this.getNumberOfGamesWon() < footballTeam1.getNumberOfGamesWon()) {
            return -1;
        }
        return 0;
    }
}
