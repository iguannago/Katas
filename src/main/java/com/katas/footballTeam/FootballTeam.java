package com.katas.footballTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return gamesWon - o.getGamesWon();
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "gamesWon=" + gamesWon +
                '}';
    }

    public static void main(String[] args) {
        FootballTeam chelsea = FootballTeam.builder(5);
        FootballTeam city = FootballTeam.builder(3);
        FootballTeam united = FootballTeam.builder(1);
        List<FootballTeam> premier = new ArrayList<>(3);
        premier.add(city);
        premier.add(united);
        premier.add(chelsea);
        System.out.println("before soring: " + premier);
        Collections.sort(premier);
        System.out.println("after soring: " + premier);
    }

}
