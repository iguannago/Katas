package teniskata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class GameTest {

    private final Player player1 = new Player("Nadal");
    private final Player player2 = new Player("Federer");

    private final Game game = new Game(player1, player2);

    @ParameterizedTest
    @EnumSource(value = Points.class, names = {"FIFTEEN", "THIRTY", "LOVE"})
    void givenPlayer1HasFortyPointsAndPlayer1WinsThePoint_whenPlay_thenPlayer1WinsTheGame(Points player2) {
        Assertions.assertEquals(player1.getName() + " wins the game",
                game.playPoint(Points.FORTY, player2, player1).getResult());
    }

    @ParameterizedTest
    @EnumSource(value = Points.class, names = {"FIFTEEN", "THIRTY", "LOVE"})
    void givenPlayer2HasFortyPointsAndPlayer2WinsThePoint_whenPlay_thenPlayer2WinsTheGame(Points player1Points) {
        Assertions.assertEquals(player2.getName() + " wins the game",
                game.playPoint(player1Points, Points.FORTY, player2).getResult());
    }

    // todo: parametrise the test to add other test scenarios
    @Test
    void givenPlayersHaveLoveAndPlayer1WinsThePoint_whenPlay_thenPlayerHasFifteen() {
        Score actual = game.playPoint(Points.LOVE, Points.LOVE, player1);
        Assertions.assertEquals(new Score(Points.FIFTEEN, Points.LOVE, player1.getName() + " wins the point"),
                actual);
    }

    @Test
    void givenPlayer1AndPlayer2HasForty_whenPlayGame_thenResultIsDeuce() {
        Assertions.assertEquals(new Score(Points.FORTY, Points.FORTY, "deuce"),
                game.playPoint(Points.FORTY, Points.THIRTY, player2));
    }

    @Test
    void givenGameIsInDeuce_whenPlayGame_thenTheWinnerHasAdvantage() {
        Assertions.assertEquals(new Score(Points.FORTY, Points.FORTY, "deuce"),
                game.playPoint(Points.THIRTY, Points.FORTY, player1));
    }
}