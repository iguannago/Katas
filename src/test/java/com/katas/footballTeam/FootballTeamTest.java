package com.katas.footballTeam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 21/11/2016.
 */
public class FootballTeamTest {

    private final FootballTeam team1 = FootballTeam.builder(1);
    private final FootballTeam team0 = FootballTeam.builder(0);

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
    public void FootballTeamWith1GamesWonRanksHigherThanFootballTeamWith0GamesWonTest() {
        assertEquals(1, team1.compareTo(team0));
    }

    @Test
    public void FootballTeamWith0GamesWonRanksLowerThanFootballTeamWith1GamesWonTest() {
        assertEquals(-1, team0.compareTo(team1));
    }

    @Test
    public void FootballTeamsWithEqualGamesWonRankEquallyTest() {
        FootballTeam anotherTeam0 = FootballTeam.builder(0);
        assertEquals(0, team0.compareTo(anotherTeam0));
    }


}
