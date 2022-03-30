package tenniskata2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TennisGameTest {

    @Test
    void givenBothPlayersHaveLoveAndThePointWinnerIsPlayer1_whenPlayGame_thenScoreIsPlayer1HasFifteenAndPlayer2HasLove() {
        Game game = new Game("Nadal", "Federer");

        Score actualScore = game.play("Nadal");

        Score expectedScore = new Score(new Player("Nadal", Point.FIFTEEN),
                new Player("Federer", Point.LOVE));
        Assertions.assertEquals(expectedScore, actualScore);
    }
}
