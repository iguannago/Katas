package com.katas.footballTeam;

/**
 * Created by davicres on 21/11/2016.
 */
public final class FootballTeam implements Comparable<FootballTeam> {

    private final int gamesWon;

    private FootballTeam(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public static FootballTeam builder(int gamesWon) {
        return new FootballTeam(gamesWon);
    }

    @Override
    public int compareTo(FootballTeam o) {
        if (gamesWon == o.getGamesWon()) {
            return 0;
        }
        if (gamesWon < o.getGamesWon()) {
            return -1;
        }
        return 1;
    }

    public int getGamesWon() {
        return gamesWon;
    }
}
