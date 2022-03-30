package tenniskata2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TennisGameTest {

    public static final String PLAYER_1_NAME = "Nadal";
    private Player player1 = null;
    public static final String PLAYER_2_NAME = "Federer";
    private Player player2 = null;
    private Game game = null;

    @Test
    void givenBothPlayersHaveLoveAndThePointWinnerIsPlayer1_whenPlayGame_thenScoreIsPlayer1HasFifteenAndPlayer2HasLove() {
        player1 = new Player(PLAYER_1_NAME, Point.LOVE);
        player2 = new Player(PLAYER_2_NAME, Point.LOVE);
        game = new Game(new Score(player1, player2));

        Score actual = game.play(PLAYER_1_NAME);

        Score expectedScore = new Score(new Player("Nadal", Point.FIFTEEN),
                new Player("Federer", Point.LOVE));
        Assertions.assertEquals(expectedScore, actual);
    }

    @Test
    void givenPlayer1HasFifteenAndThePointWinnerIsPlayer1_whenPlayGame_thenScoreIsPlayer1HasThirtyAndPlayer2HasLove() {
        player1 = new Player(PLAYER_1_NAME, Point.FIFTEEN);
        player2 = new Player(PLAYER_2_NAME, Point.LOVE);
        game = new Game(new Score(player1, player2));

        Score actual = game.play(PLAYER_1_NAME);

        Score expectedScore = new Score(new Player("Nadal", Point.THIRTY),
                new Player("Federer", Point.LOVE));
        Assertions.assertEquals(expectedScore, actual);
    }
}
