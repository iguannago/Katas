package com.katas.footballTeam;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by davicres on 21/11/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    @Test
    public void constructorTest() {
        FootballTeam footballTeam = FootballTeam.builder(2);
        assertNotNull(footballTeam);
    }

    @Test
    public void sortFootballTeamsTest() {
        List<FootballTeam> footballTeamList = new ArrayList<>();
        Collections.sort(footballTeamList);
    }

    @Test
    @Parameters({"1, 0", "4, 2", "8, 0", "4, 3"})
    public void FootballTeamWith1GamesWonRanksHigherThanFootballTeamWith0GamesWonTest(int gamesWonA, int gamesWonB) {
        FootballTeam teamA = FootballTeam.builder(gamesWonA);
        FootballTeam teamB = FootballTeam.builder(gamesWonB);
        assertTrue(teamA.compareTo(teamB) > 0);
    }

    @Test
    @Parameters({"0, 1", "2, 4", "0, 8", "3, 4"})
    public void FootballTeamWith0GamesWonRanksLowerThanFootballTeamWith1GamesWonTest(int gamesWonA, int gamesWonB) {
        FootballTeam teamA = FootballTeam.builder(gamesWonA);
        FootballTeam teamB = FootballTeam.builder(gamesWonB);
        assertTrue(teamA.compareTo(teamB) < 0);
    }

    @Test
    public void FootballTeamsWithEqualGamesWonRankEquallyTest() {
        FootballTeam anotherTeamB = FootballTeam.builder(0);
        FootballTeam teamB = FootballTeam.builder(0);
        assertTrue(teamB.compareTo(anotherTeamB) == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void footballTeamWithLessThanZeroGamesWonThrowAnExceptionTest() {
        FootballTeam.builder(-1);
    }


}
