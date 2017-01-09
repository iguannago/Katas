package com.katas.footballTeam;

import org.junit.Test;

/**
 * Created by davicres on 09/01/2017.
 */
public class FootballTeamTest1 {
    @Test
    public void giveMeNumberOfGamesWon() throws Exception {
        FootballTeam1 footballTeam1 = new FootballTeam1(1);
        org.junit.Assert.assertEquals(1, footballTeam1.getNumberOfGamesWon());

    }
}
