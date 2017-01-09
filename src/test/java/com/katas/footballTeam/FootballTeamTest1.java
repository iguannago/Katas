package com.katas.footballTeam;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 09/01/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest1 {
    @Test
    public void giveMeNumberOfGamesWon() throws Exception {
        assertEquals(1, FootballTeam1.build(1).getNumberOfGamesWon());
    }

    @Test
    @Parameters({"1, 0", "4, 0"})
    public void footballTeamWith1GameWonRankHigherThanFootballTeamWith0GamesWon(int teamAGames, int teamBGames)
            throws Exception {
        FootballTeam1 teamA = FootballTeam1.build(teamAGames);
        FootballTeam1 teamB = FootballTeam1.build(teamBGames);
        assertEquals(true, teamA.compareTo(teamB) > 0);
    }

    @Test
    @Parameters({"0, 1", "1, 8"})
    public void teamWithFewerGamesWonRankLowerThanTeamWithGreaterGamesWon(int teamAGames, int teamBGames)
            throws Exception {
        FootballTeam1 teamA = FootballTeam1.build(teamAGames);
        FootballTeam1 teamB = FootballTeam1.build(teamBGames);
        assertEquals(true, teamA.compareTo(teamB) < 0);
    }

    @Test
    @Parameters({"1, 1", "0, 0"})
    public void teamWithEqualGamesWonRankEqually(int teamAGames, int teamBGames) throws Exception {
        FootballTeam1 teamA = FootballTeam1.build(teamAGames);
        FootballTeam1 teamB = FootballTeam1.build(teamBGames);
        assertEquals(true, teamB.compareTo(teamA) == 0);
    }

    //Corner case

    @Test(expected = IllegalArgumentException.class)
    public void ifNumberOfGamesIsLessThanZeroThrowException() throws Exception {
        FootballTeam1.build(-1);
    }
}
