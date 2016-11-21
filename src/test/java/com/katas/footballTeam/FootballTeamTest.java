package com.katas.footballTeam;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    @Parameters({"1, 0"})
    public void FootballTeamWith1GamesWonRanksHigherThanFootballTeamWith0GamesWonTest(int gamesWonA, int gamesWonB) {
        FootballTeam teamA = FootballTeam.builder(gamesWonA);
        FootballTeam teamB = FootballTeam.builder(gamesWonB);
        assertEquals(1, teamA.compareTo(teamB));
    }

    @Test
    public void FootballTeamWith0GamesWonRanksLowerThanFootballTeamWith1GamesWonTest() {
        FootballTeam teamA = FootballTeam.builder(1);
        FootballTeam teamB = FootballTeam.builder(0);
        assertEquals(-1, teamB.compareTo(teamA));
    }

    @Test
    public void FootballTeamsWithEqualGamesWonRankEquallyTest() {
        FootballTeam anotherTeamB = FootballTeam.builder(0);
        FootballTeam teamB = FootballTeam.builder(0);
        assertEquals(0, teamB.compareTo(anotherTeamB));
    }


}
