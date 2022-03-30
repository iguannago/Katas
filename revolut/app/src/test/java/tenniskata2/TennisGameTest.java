package tenniskata2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TennisGameTest {

    public static final String PLAYER_1_NAME = "Nadal";
    private Player player1 = null;
    public static final String PLAYER_2_NAME = "Federer";
    private Player player2 = null;
    private Game game = null;

    public static Stream<Arguments> scenarioProvider() {
        return Stream.of(
                Arguments.of(Point.LOVE, Point.LOVE, PLAYER_1_NAME, Point.FIFTEEN, Point.LOVE),
                Arguments.of(Point.FIFTEEN, Point.LOVE, PLAYER_1_NAME, Point.THIRTY, Point.LOVE),
                Arguments.of(Point.THIRTY, Point.LOVE, PLAYER_1_NAME, Point.FORTY, Point.LOVE),
                Arguments.of(Point.FORTY, Point.LOVE, PLAYER_1_NAME, Point.ADVANTAGE, Point.LOVE)
        );
    }

    @ParameterizedTest
    @MethodSource("scenarioProvider")
    void givenPlayersAndScore_whenPlayGame_thenScoreHasProgressedAsExpected(
            Point player1Points,
            Point player2Points,
            String winner,
            Point expectedPlayer1Points,
            Point expectedPlayer2Points
    ) {
        player1 = new Player(PLAYER_1_NAME, player1Points);
        player2 = new Player(PLAYER_2_NAME, player2Points);
        game = new Game(new Score(player1, player2));

        Score actual = game.play(winner);

        Score expectedScore = new Score(new Player("Nadal", expectedPlayer1Points),
                new Player("Federer", expectedPlayer2Points));
        Assertions.assertEquals(expectedScore, actual);
    }

}
