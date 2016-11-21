package com.katas.footballTeam;

/**
 * Created by davicres on 21/11/2016.
 */
public final class FootballTeam implements Comparable<FootballTeam> {
    private FootballTeam(int gamesWon) {

    }

    public static FootballTeam builder(int gamesWon) {
        return new FootballTeam(gamesWon);
    }

    @Override
    public int compareTo(FootballTeam o) {
        return 1;
    }
}
