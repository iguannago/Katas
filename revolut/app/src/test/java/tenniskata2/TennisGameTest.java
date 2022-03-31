package tenniskata2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TennisGameTest {

    public static final String PLAYER_1_NAME = "Nadal";
    public static final String PLAYER_2_NAME = "Federer";

    public static Stream<Arguments> scenarioProvider() {
        return Stream.of(
                Arguments.of(Point.LOVE, Point.LOVE, PLAYER_1_NAME, Point.FIFTEEN, Point.LOVE, null),
                Arguments.of(Point.FIFTEEN, Point.LOVE, PLAYER_1_NAME, Point.THIRTY, Point.LOVE, null),
                Arguments.of(Point.THIRTY, Point.LOVE, PLAYER_1_NAME, Point.FORTY, Point.LOVE, null),
                Arguments.of(Point.FORTY, Point.LOVE, PLAYER_1_NAME, Point.FORTY, Point.LOVE, "Nadal wins the game"),

                Arguments.of(Point.LOVE, Point.LOVE, PLAYER_2_NAME, Point.LOVE, Point.FIFTEEN, null),
                Arguments.of(Point.LOVE, Point.FIFTEEN, PLAYER_2_NAME, Point.LOVE, Point.THIRTY, null),
                Arguments.of(Point.LOVE, Point.THIRTY, PLAYER_2_NAME, Point.LOVE, Point.FORTY, null),
                Arguments.of(Point.LOVE, Point.FORTY, PLAYER_2_NAME, Point.LOVE, Point.FORTY, "Federer wins the game"),

                Arguments.of(Point.THIRTY, Point.FORTY, PLAYER_1_NAME, Point.FORTY, Point.FORTY, "deuce"),
                Arguments.of(Point.FORTY, Point.THIRTY, PLAYER_2_NAME, Point.FORTY, Point.FORTY, "deuce"),

                Arguments.of(Point.FORTY, Point.FORTY, PLAYER_1_NAME, Point.ADVANTAGE, Point.FORTY, "Nadal's advantage"),
                Arguments.of(Point.FORTY, Point.FORTY, PLAYER_2_NAME, Point.FORTY, Point.ADVANTAGE, "Federer's advantage"),

                Arguments.of(Point.ADVANTAGE, Point.FORTY, PLAYER_1_NAME, Point.ADVANTAGE, Point.FORTY, "Nadal wins the game"),
                Arguments.of(Point.FORTY, Point.ADVANTAGE, PLAYER_2_NAME, Point.FORTY, Point.ADVANTAGE, "Federer wins the game"),

                Arguments.of(Point.ADVANTAGE, Point.FORTY, PLAYER_2_NAME, Point.FORTY, Point.FORTY, "deuce"),
                Arguments.of(Point.FORTY, Point.ADVANTAGE, PLAYER_1_NAME, Point.FORTY, Point.FORTY, "deuce")
        );
    }

    @ParameterizedTest
    @MethodSource("scenarioProvider")
    void givenPlayersAndScore_whenPlayGame_thenScoreHasProgressedAsExpected(
            Point player1Points,
            Point player2Points,
            String winner,
            Point expectedPlayer1Points,
            Point expectedPlayer2Points,
            String expectedResult
    ) {
        Player player1 = new Player(PLAYER_1_NAME, player1Points);
        Player player2 = new Player(PLAYER_2_NAME, player2Points);
        Game game = new Game(player1, player2);

        Score actual = game.play(winner);

        Score expectedScore = new Score(new Player(PLAYER_1_NAME, expectedPlayer1Points),
                new Player(PLAYER_2_NAME, expectedPlayer2Points), expectedResult);
        Assertions.assertEquals(expectedScore, actual);
    }

}
