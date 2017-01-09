package com.katas.footballTeam;

/**
 * Created by davicres on 09/01/2017.
 */
public final class FootballTeam1 implements Comparable<FootballTeam1> {
    private final int numberOfGamesWon;

    private FootballTeam1(int numberOfGamesWon) {
        this.numberOfGamesWon = numberOfGamesWon;
    }

    public static FootballTeam1 build(int numberOfGamesWon) {
        if (numberOfGamesWon < 0) {
            throw new IllegalArgumentException("Less Than Zero");
        }
        return new FootballTeam1(numberOfGamesWon);
    }

    int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    @Override
    public int compareTo(FootballTeam1 o) {
        return this.getNumberOfGamesWon() - o.getNumberOfGamesWon();
    }
}
