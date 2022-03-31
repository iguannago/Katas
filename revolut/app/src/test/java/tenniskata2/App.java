package tenniskata2;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        Player pl1 = new Player("Nadal", Point.LOVE);
        Player pl2 = new Player("Federer", Point.LOVE);
        Score score = new Score(pl1, pl2, null);
        Game game = new Game(pl1, pl2);

        String endgame = "";
        System.out.println("Initial score: " + score);
        while (!endgame.contains("wins the game")) {
            score = game.play(pickWinner());
            game = new Game(score.getPlayer1(), score.getPlayer2());
            endgame = Optional.ofNullable(score.getResult()).orElse("");
            System.out.println("score: " + score + "\n");
        }
        System.out.println("Final result: " + score.getResult());
    }

    private static String pickWinner() {
        return (Math.random() <= 0.5) ? "Nadal" : "Federer";
    }
}
