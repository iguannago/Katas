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
}
