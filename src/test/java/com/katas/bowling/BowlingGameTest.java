package com.katas.bowling;

import com.katas.bowlingGame.BowlingGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    @Test
    public void gameShouldHaveTwoPlayersTest() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        int numOfPlayers = bowlingGame.numberOfPlayers();
        assertEquals(2, numOfPlayers);
    }
}
