package tenniskata2;

public class App {
    public static void main(String[] args) {
        Player pl1 = new Player("Nadal", Point.LOVE);
        Player pl2 = new Player("Federer", Point.LOVE);
        Score score = new Score(pl1, pl2, null);
        Game game = new Game(score);

        for (int i = 0; i < 5; i++) {
            System.out.println("score: " + score);
            score = game.play(pickWinner());
            game = new Game(score);
        }
    }

    private static String pickWinner() {
        return (Math.random() <= 0.5) ? "Nadal" : "Federer";
    }
}
