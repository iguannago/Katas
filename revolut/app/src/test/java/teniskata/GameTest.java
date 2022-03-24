package teniskata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GameTest {

    private final Player player1 = new Player("Nadal");
    private final Player player2 = new Player("Federer");

    private final Game game = new Game(player1, player2);

    @ParameterizedTest
    @MethodSource("playTestScenarioProvider")
    void playTest(GameScenario scenario) {
        Score actual = game.play(scenario.player1Points, scenario.player2Points, scenario.winner);

        Assertions.assertEquals(scenario.expectedScore, actual);
    }

    public static Stream<GameScenario> playTestScenarioProvider() {
        Player player1 = new Player("Nadal");
        Player player2 = new Player("Federer");

        // player1 wins the game in straight points
        GameScenario gameScenario = new GameScenario(Points.LOVE,
                Points.LOVE,
                player1,
                new Score(Points.FIFTEEN, Points.LOVE, player1.getName() + " wins the point"));
        GameScenario gameScenario1 = new GameScenario(Points.FIFTEEN,
                Points.LOVE,
                player1,
                new Score(Points.THIRTY, Points.LOVE, player1.getName() + " wins the point"));
        GameScenario gameScenario2 = new GameScenario(Points.THIRTY,
                Points.LOVE,
                player1,
                new Score(Points.FORTY, Points.LOVE, player1.getName() + " wins the point"));
        GameScenario gameScenario3 = new GameScenario(Points.FORTY,
                Points.LOVE,
                player1,
                new Score(Points.FORTY, Points.LOVE, player1.getName() + " wins the game"));

        // player2 wins the game in straight points
        GameScenario gameScenarioPlayer2 = new GameScenario(Points.LOVE,
                Points.LOVE,
                player2,
                new Score(Points.LOVE, Points.FIFTEEN, player2.getName() + " wins the point"));
        GameScenario gameScenario1Player2 = new GameScenario(Points.LOVE,
                Points.FIFTEEN,
                player2,
                new Score(Points.LOVE, Points.THIRTY, player2.getName() + " wins the point"));
        GameScenario gameScenario2Player2 = new GameScenario(Points.LOVE,
                Points.THIRTY,
                player2,
                new Score(Points.LOVE, Points.FORTY, player2.getName() + " wins the point"));
        GameScenario gameScenario3Player2 = new GameScenario(Points.LOVE,
                Points.FORTY,
                player2,
                new Score(Points.LOVE, Points.FORTY, player2.getName() + " wins the game"));


        //Player1 wins the the game from a deuce situation
        GameScenario gameScenario4 = new GameScenario(Points.FORTY,
                Points.FORTY,
                player1,
                new Score(Points.A, Points.FORTY, player1.getName() + " advantage"));
        GameScenario gameScenario5 = new GameScenario(Points.A,
                Points.FORTY,
                player1,
                new Score(Points.A, Points.FORTY, player1.getName() + " wins the game"));


        //Player2 wins the the game from a deuce situation
        GameScenario gameScenario4Player2 = new GameScenario(Points.FORTY,
                Points.FORTY,
                player2,
                new Score(Points.FORTY, Points.A, player2.getName() + " advantage"));
        GameScenario gameScenario5Player2 = new GameScenario(Points.FORTY,
                Points.A,
                player2,
                new Score(Points.FORTY, Points.A, player2.getName() + " wins the game"));

        //deuce
        GameScenario gameScenarioDeuce = new GameScenario(Points.THIRTY,
                Points.FORTY,
                player1,
                new Score(Points.FORTY, Points.FORTY, "deuce"));
        //player2 deuce
        GameScenario gameScenarioDeucePlayer2 = new GameScenario(Points.FORTY,
                Points.THIRTY,
                player2,
                new Score(Points.FORTY, Points.FORTY, "deuce"));

        //back to deuce
        GameScenario gameScenarioBackDeuce = new GameScenario(Points.A,
                Points.FORTY,
                player2,
                new Score(Points.FORTY, Points.FORTY, "deuce"));

        //back to deuce player2
        GameScenario gameScenarioBackDeucePlayer2 = new GameScenario(Points.FORTY,
                Points.A,
                player1,
                new Score(Points.FORTY, Points.FORTY, "deuce"));


        return Stream.of(
                gameScenario,
                gameScenario1,
                gameScenario2,
                gameScenario3,
                gameScenario4,
                gameScenario5,
                gameScenarioPlayer2,
                gameScenario1Player2,
                gameScenario2Player2,
                gameScenario3Player2,
                gameScenario4Player2,
                gameScenario5Player2,
                gameScenarioDeuce,
                gameScenarioDeucePlayer2,
                gameScenarioBackDeuce,
                gameScenarioBackDeucePlayer2
        );
    }

    private static class GameScenario {
        final Points player1Points;
        final Points player2Points;
        final Player winner;
        final Score expectedScore;

        public GameScenario(Points player1Points,
                            Points player2Points,
                            Player winner,
                            Score expectedScore) {
            this.player1Points = player1Points;
            this.player2Points = player2Points;
            this.winner = winner;
            this.expectedScore = expectedScore;
        }
    }

}