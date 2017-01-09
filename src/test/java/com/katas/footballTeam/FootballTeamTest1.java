package com.katas.footballTeam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 09/01/2017.
 */
public class FootballTeamTest1 {
    @Test
    public void giveMeNumberOfGamesWon() throws Exception {
        assertEquals(1, FootballTeam1.build(1).getNumberOfGamesWon());
    }

    @Test
    public void footballTeamWith1GameWonRankHigherThanFootballTeamWith0GamesWon() throws Exception {
        FootballTeam1 footballTeam1With1GameWon = FootballTeam1.build(1);
        FootballTeam1 footballTeam1With0GamesWon = FootballTeam1.build(0);
        assertEquals(true, footballTeam1With1GameWon.compareTo(footballTeam1With0GamesWon) == 1);
    }

    @Test
    public void teamWithFewerGamesWonRankLowerThanTeamWithGreaterGamesWon() throws Exception {
        FootballTeam1 footballTeam1With1GameWon = FootballTeam1.build(1);
        FootballTeam1 footballTeam1With0GamesWon = FootballTeam1.build(0);
        assertEquals(true, footballTeam1With0GamesWon.compareTo(footballTeam1With1GameWon) < 0);
    }

    @Test
    public void teamWithEqualGamesWonRankEqually() throws Exception {
        FootballTeam1 footballTeam1With1GameWon = FootballTeam1.build(1);
        FootballTeam1 footballTeam1With0GamesWon = FootballTeam1.build(1);
        assertEquals(true, footballTeam1With0GamesWon.compareTo(footballTeam1With1GameWon) == 0);
    }
}
